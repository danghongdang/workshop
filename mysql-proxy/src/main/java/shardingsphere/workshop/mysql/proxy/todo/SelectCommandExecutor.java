package shardingsphere.workshop.mysql.proxy.todo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.csv.CSVRecord;
import shardingsphere.workshop.mysql.proxy.fixture.packet.constant.MySQLColumnType;
import shardingsphere.workshop.mysql.proxy.todo.packet.MySQLColumnDefinition41Packet;
import shardingsphere.workshop.mysql.proxy.todo.packet.MySQLEofPacket;
import shardingsphere.workshop.mysql.proxy.todo.packet.MySQLFieldCountPacket;
import shardingsphere.workshop.mysql.proxy.todo.packet.MySQLTextResultSetRowPacket;
import shardingsphere.workshop.parser.exception.SQLParsingException;
import shardingsphere.workshop.parser.statement.segment.ColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnValueSegment;
import shardingsphere.workshop.parser.statement.statement.SelectStatement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectCommandExecutor extends BaseExecutor {

    public void executor(SelectStatement selectStatement, ChannelHandlerContext context) {
        // 选table
        String tableName = selectStatement.getTableNameSegment().getIdentifier().getValue();
        List<CSVRecord> csvRecords;
        try {
            csvRecords = readCsv(tableName);
        } catch (IOException e) {
            throw new SQLParsingException(String.format("table `%s` not exists", tableName));
        }
        // 过滤行 where
        Map<String, String> whereMap = Maps.newHashMap();
        Iterator<WhereColumnNameSegment> nameIt = selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnNameSegmentList().iterator();
        Iterator<WhereColumnValueSegment> valueIt = selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnValueSegmentList().iterator();
        while (nameIt.hasNext() && valueIt.hasNext()) {
            WhereColumnNameSegment columnNameSegment = nameIt.next();
            WhereColumnValueSegment columnValueSegment = valueIt.next();
            whereMap.put(columnNameSegment.getIdentifier().getValue(), columnValueSegment.getIdentifier().getValue());
        }

        List<CSVRecord> filteredRecord = readWhereValue(whereMap, csvRecords);
        // 过滤列名
        List<String> columnNameList = Lists.newArrayList();
        for (ColumnNameSegment columnNameSegment : selectStatement.getSelectColumnNamesSegment().getColumnNameSegmentList()) {
            columnNameList.add(columnNameSegment.getIdentifier().getValue());
        }
        List<List<Object>> resultList = readColumnValue(columnNameList, filteredRecord);
        Map<String, String> propertyMap = readColumnProperty(columnNameList, filteredRecord.get(0));
        // 组装mysql 协议
        int sequenceNo = 1;
        context.write(new MySQLFieldCountPacket(sequenceNo, columnNameList.size()));
        for (String name : columnNameList) {
            sequenceNo ++;
            String property = propertyMap.get(name);
            context.write(new MySQLColumnDefinition41Packet(sequenceNo, 0, "sharding_db", "t_order",
                    "t_order", name, name, 100, getType(property),0));
        }
        context.write(new MySQLEofPacket(++sequenceNo));
        for (List<Object> list : resultList) {
            sequenceNo ++;
            context.write(new MySQLTextResultSetRowPacket(sequenceNo, list));
        }
        context.write(new MySQLEofPacket(++sequenceNo));
        context.flush();
    }

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
