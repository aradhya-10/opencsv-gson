package com.csvReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.Reader;
import  java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH="D:/GE/openCSVandGSON/src/main/java/com/csvReader/users.csv";

    public static void main(String[] args) throws IOException , CsvException {
        try{
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvreader = new CSVReader(reader);

            String[] nextRecord;
            while ((nextRecord = csvreader.readNext()) != null) {
                System.out.println("Name: " + nextRecord[0]);
                System.out.println("Email: " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country: " + nextRecord[3]);
            }
        }catch(IOException e){
            throw new IOException();
        }catch( CsvException e){
            throw new CsvException();
        }
    }
}