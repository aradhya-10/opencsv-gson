package com.csvReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
public class OpenCSV {
    private static final String SAMPLE_CSV_FILE_PATH="D:/GE/openCSVandGSON/src/main/java/com/csvReader/user.csv";
    //read the user.csv file and populate the instances of CSVUser
    public static void main(String[] args) throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBean<UsersCSV> csvToBean = new CsvToBeanBuilder(reader)
                .withType(UsersCSV.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<UsersCSV> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()) {
            UsersCSV csvUser = csvUserIterator.next();
            System.out.println("Name : " + csvUser.getName());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getPhoneNo());
            System.out.println("Country : " + csvUser.getCountry());
        }
    }
}


