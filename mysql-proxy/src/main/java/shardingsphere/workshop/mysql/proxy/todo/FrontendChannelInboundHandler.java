
package shardingsphere.workshop.mysql.proxy.todo;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shardingsphere.workshop.mysql.proxy.fixture.MySQLAuthenticationHandler;
import shardingsphere.workshop.mysql.proxy.fixture.packet.MySQLErrPacketFactory;
import shardingsphere.workshop.mysql.proxy.fixture.packet.MySQLPacketPayload;
import shardingsphere.workshop.mysql.proxy.fixture.packet.constant.MySQLColumnType;
import shardingsphere.workshop.mysql.proxy.todo.packet.*;
import shardingsphere.workshop.parser.engine.ParseEngine;
import shardingsphere.workshop.parser.exception.SQLParsingException;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.ColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnValueSegment;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;
import shardingsphere.workshop.parser.statement.statement.SelectStatement;
import shardingsphere.workshop.parser.statement.statement.UpdateStatement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Frontend channel inbound handler.
 */
@RequiredArgsConstructor
@Slf4j
public final class FrontendChannelInboundHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontendChannelInboundHandler.class);
    
    private final MySQLAuthenticationHandler authHandler = new MySQLAuthenticationHandler();
    
    private boolean authorized;
    
    @Override
    public void channelActive(final ChannelHandlerContext context) {
        authHandler.handshake(context);
    }
    
    @Override
    public void channelRead(final ChannelHandlerContext context, final Object message) {
        if (!authorized) {
            authorized = auth(context, (ByteBuf) message);
            return;
        }
        try (MySQLPacketPayload payload = new MySQLPacketPayload((ByteBuf) message)) {
            executeCommand(context, payload);
        } catch (final Exception ex) {
            log.error("Exception occur: ", ex);
            context.writeAndFlush(MySQLErrPacketFactory.newInstance(1, ex));
        }
    }
    
    @Override
    public void channelInactive(final ChannelHandlerContext context) {
        context.fireChannelInactive();
    }
    
    private boolean auth(final ChannelHandlerContext context, final ByteBuf message) {
        try (MySQLPacketPayload payload = new MySQLPacketPayload(message)) {
            return authHandler.auth(context, payload);
        } catch (final Exception ex) {
            log.error("Exception occur: ", ex);
            context.write(MySQLErrPacketFactory.newInstance(1, ex));
        }
        return false;
    }

    private static final List<String> dbList = ImmutableList.of("sharding_db");

    /**
     * 时间的原因仅仅实现了 select * || columns from t_order where order_id=1000001 and user_id = 10
     * @param context
     * @param payload
     */
    private void executeCommand(final ChannelHandlerContext context, final MySQLPacketPayload payload) {
        int commandType = payload.readInt1();
        LOGGER.info("load type:{}", commandType);
        Preconditions.checkState(0x03 == commandType || 0x02 == commandType, "only support COM_QUERY or COM_INIT_DB command type");
        // TODO 1. Read SQL from payload, then system.out it
        // TODO 2. Return mock MySQLPacket to client (header: MySQLFieldCountPacket + MySQLColumnDefinition41Packet + MySQLEofPacket, content: MySQLTextResultSetRowPacket
        // TODO 3. Parse SQL, return actual data according to SQLStatement

        String sql = payload.readStringEOF();
        LOGGER.info("execute sql:{}", sql);
        if (sql.startsWith("select @@version_comment") || sql.startsWith("SELECT DATABASE()") || dbList.contains(sql)
                || sql.startsWith("show database") || sql.startsWith("show tables")) {
            context.write(new MySQLOkPacket(1));
            context.flush();
            return;
        }
        ASTNode astNode = ParseEngine.parse(sql);
        if (astNode instanceof InsertStatement) {
            InsertStatement insertStatement = (InsertStatement) astNode;
            new InsertCommandExecutor().executor(insertStatement, context);
            context.write(new MySQLOkPacket(1));
            context.flush();
        } else if (astNode instanceof SelectStatement) {
            SelectStatement selectStatement = (SelectStatement) astNode;
            new SelectCommandExecutor().executor(selectStatement, context);
        } else if (astNode instanceof UpdateStatement) {
            LOGGER.info("unsupported sql grammar!");
            UpdateStatement updateStatement = (UpdateStatement) astNode;
            LOGGER.info("select column name : {}", updateStatement.getUpdateColumnNameAndValuesSegment());
            LOGGER.info("table name : {}", updateStatement.getTableNameSegment());
            LOGGER.info("where name : {}", updateStatement.getWhereColumnNameAndValuesSegment());
            context.write(new MySQLOkPacket(1));
            context.flush();
        } else {
            throw new SQLParsingException(String.format("Unsupported SQL of `%s`", sql));
        }
    }

    private List<CSVRecord> readCsv(String fileName) throws IOException {
        fileName = "/data/" + fileName + ".csv";
        Reader in = new FileReader(this.getClass().getResource(fileName).getPath());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        return Lists.newArrayList(records);
    }

    private static final Splitter SPLITTER = Splitter.on(":").omitEmptyStrings().trimResults();

    private Map<String, String> readColumnProperty(List<String> columnNameList, CSVRecord head) {
        Map<String, String> columnPropertyMap = Maps.newHashMap();
        for (String str : head) {
            List<String> list = Lists.newArrayList(SPLITTER.split(str));
            for (String columnName : columnNameList) {
                if (columnName.equalsIgnoreCase(list.get(0))) {
                    columnPropertyMap.put(columnName, list.get(1));
                }
            }
        }
        return columnPropertyMap;
    }

    private List<CSVRecord> readWhereValue(Map<String, String> whereMap, List<CSVRecord> csvRecords) {
        if (whereMap.isEmpty()) {
            return csvRecords;
        }
        CSVRecord head = csvRecords.get(0);
        int index = 0;
        Map<Integer, String> indexWhereMap = Maps.newHashMap();
        for (String str : head) {
            List<String> list = Lists.newArrayList(SPLITTER.split(str));
            for (Map.Entry<String, String> entry : whereMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(list.get(0))) {
                    indexWhereMap.put(index, entry.getValue());
                }
            }
            index ++;
        }
        boolean equals = false;
        List<CSVRecord> filteredRecords = Lists.newArrayList();
        filteredRecords.add(head);
        for (int i=1; i<csvRecords.size(); i++) {
            CSVRecord csvRecord = csvRecords.get(i);
            for (Map.Entry<Integer, String> entry : indexWhereMap.entrySet()) {
                equals = false;
                int idx = entry.getKey();
                String value = entry.getValue();
                if (csvRecord.get(idx).equalsIgnoreCase(value)) {
                    equals = true;
                } else {
                    break;
                }
            }
            if (equals) {
                filteredRecords.add(csvRecord);
            }
        }
        return filteredRecords;
    }

    private List<List<Object>> readColumnValue(List<String> columnNameList, List<CSVRecord> recordList) {
        CSVRecord head = recordList.get(0);
        if (columnNameList.isEmpty()) {
            for (String str : head) {
                List<String> list = Lists.newArrayList(SPLITTER.split(str));
                columnNameList.add(list.get(0));
            }
        }
        List<Integer> readColumnIndexList = Lists.newArrayList();
        int index = 0;
        for (String str : head) {
            List<String> list = Lists.newArrayList(SPLITTER.split(str));
            for (String columnName : columnNameList) {
                if (columnName.equalsIgnoreCase(list.get(0))) {
                    readColumnIndexList.add(index);
                }
            }
            index ++;
        }
        List<List<Object>> resultList = Lists.newArrayList();
        for (int i=1; i<recordList.size(); i++) {
            List<Object> columnValueList = Lists.newArrayList();
            CSVRecord csvRecord = recordList.get(i);
            for (int idx : readColumnIndexList) {
                columnValueList.add(csvRecord.get(idx));
            }
            resultList.add(columnValueList);
        }
        return resultList;
    }

    private MySQLColumnType getType(String type) {
        if ("long".equalsIgnoreCase(type)) {
            return MySQLColumnType.MYSQL_TYPE_LONG;
        } else if ("int".equalsIgnoreCase(type)) {
            return MySQLColumnType.MYSQL_TYPE_INT24;
        } else if ("string".equalsIgnoreCase(type)) {
            return MySQLColumnType.MYSQL_TYPE_VARCHAR;
        } else {
            return MySQLColumnType.MYSQL_TYPE_VARCHAR;
        }
    }
}
