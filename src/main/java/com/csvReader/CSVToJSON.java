package com.csvReader;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class CSVToJSON {
    private static final String SAMPLE_CSV_FILE_PATH="D:/GE/openCSVandGSON/src/main/java/com/csvReader/user.csv";
    private static final String SAMPLE_JSON_FILE_PATH="D:/GE/openCSVandGSON/src/main/java/com/csvReader/users.json";
    // reading from user.csv and write  in users.json
    public static void main(String[] args) throws IOException, CsvException {
        Reader reader= Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBeanBuilder<UsersCSV> csvToBeanBuilder= new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(UsersCSV.class);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<UsersCSV> csvToBean= csvToBeanBuilder.build();
        List<UsersCSV> csvUsers= csvToBean.parse();
        Gson gson = new Gson();
        String json= gson.toJson(csvUsers);
        FileWriter writer= new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        BufferedReader br= new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
        UsersCSV[] usrObj= gson.fromJson(br,UsersCSV[].class);
        List<UsersCSV> csvUserList= Arrays.asList(usrObj);
    }
}
