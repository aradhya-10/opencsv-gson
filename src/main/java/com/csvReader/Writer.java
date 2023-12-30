package com.csvReader;


import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Writer {
    private static final String SAMPLE_CSV_FILE_PATH="D:/GE/openCSVandGSON/src/main/java/com/csvReader/writer.csv";
    public static void main(String[] args) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(Paths.get(SAMPLE_CSV_FILE_PATH))));
        //Create record
        List<String[]> records= new ArrayList<>();
        records.add("Rajeev Kumar Singh,rajeevs@example.com,+91-9999999999,India".split(","));
        records.add("Barak Obama,barak.obama@example.com,+1-1111111111,United States".split(","));
        //Write the record to file
        for(String[] record : records) {
            writer.writeNext(record, false);
        }
        //close the writer
        writer.close();
    }
}
