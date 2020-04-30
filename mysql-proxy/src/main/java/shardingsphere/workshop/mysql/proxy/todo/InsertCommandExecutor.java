package shardingsphere.workshop.mysql.proxy.todo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.csv.CSVRecord;
import shardingsphere.workshop.mysql.proxy.todo.packet.MySQLOkPacket;
import shardingsphere.workshop.parser.exception.SQLParsingException;
import shardingsphere.workshop.parser.statement.segment.AssignmentValueSegment;
import shardingsphere.workshop.parser.statement.segment.ColumnNameSegment;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InsertCommandExecutor extends BaseExecutor {

    public void executor(InsertStatement insertStatement, ChannelHandlerContext context) {
        // 选table
        String tableName = insertStatement.getTableNameSegment().getIdentifier().getValue();
        List<CSVRecord> csvRecords;
        try {
            csvRecords = readCsv(tableName);
        } catch (IOException e) {
            throw new SQLParsingException(String.format("table `%s` not exists", tableName));
        }
        // 选出所有的列名
        CSVRecord head = csvRecords.get(0);
        List<String> allColumnList = Lists.newArrayList();
        for (String name : head) {
            List<String> list = SPLITTER.splitToList(name);
            allColumnList.add(list.get(0));
        }
        // 选出指定的列名
        List<String> columnNameList = Lists.newArrayList();
        for (ColumnNameSegment segment : insertStatement.getColumnNamesSegment().getColumnNameSegmentList()) {
            columnNameList.add(segment.getIdentifier().getValue());
        }
        // 选出列名所在的位置
        List<Integer> indexList = Lists.newArrayList();
        for (int i=0; i<allColumnList.size(); i++) {
            for (String str : columnNameList) {
                if (str.equalsIgnoreCase(allColumnList.get(i))) {
                    indexList.add(i);
                    break;
                }
            }
        }
        // 选出所有的要插入的值
        List<String> valueList = Lists.newArrayList();
        for (AssignmentValueSegment value : insertStatement.getAssignmentValuesSegment().getAssignmentValueSegments()) {
            valueList.add(value.getIdentifier().getValue());
        }
        Map<Integer, String> indexValueMap = Maps.newHashMap();
        Iterator<Integer> indexIt = indexList.iterator();
        Iterator<String> valueIt = valueList.iterator();
        while (indexIt.hasNext() && valueIt.hasNext()) {
            indexValueMap.put(indexIt.next(), valueIt.next());
        }
        List<String> writeList = Lists.newArrayList();
        for (int i=0; i<allColumnList.size(); i++) {
            String value = indexValueMap.get(i);
            if (value == null) {
                value = "null";
            }
            writeList.add(value);
        }
        // 写csv文件
        try {
            writeCsv(tableName, writeList);
        } catch (IOException e) {
            throw new SQLParsingException(String.format("save table '%s' error", tableName));
        }
        // 组装mysql 协议
        context.write(new MySQLOkPacket(1));
        context.flush();
    }
}
