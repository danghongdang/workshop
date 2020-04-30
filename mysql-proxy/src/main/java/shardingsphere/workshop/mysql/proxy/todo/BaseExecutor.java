package shardingsphere.workshop.mysql.proxy.todo;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class BaseExecutor {

    public static final Splitter SPLITTER = Splitter.on(":").omitEmptyStrings().trimResults();

    public List<CSVRecord> readCsv(String fileName) throws IOException {
        fileName = "/data/" + fileName + ".csv";
        try (Reader in = new FileReader(this.getClass().getResource(fileName).getPath())) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            return Lists.newArrayList(records);
        }
    }

    public void writeCsv(String fileName, List<String> list) throws IOException {
        fileName = "/data/" + fileName + ".csv";
        try (Writer writer = new FileWriter(this.getClass().getResource(fileName).getPath(), true)) {
            try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL)) {
                printer.printRecord(list);
            }
        }
    }
}
