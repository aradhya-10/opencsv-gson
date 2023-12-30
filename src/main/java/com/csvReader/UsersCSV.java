package com.csvReader;
import com.opencsv.bean.CsvBindByName;

//Java POJO is CSVUser class with all fields are of string type

public class UsersCSV {
    @CsvBindByName
    private String name;
    @CsvBindByName(column="email", required = true)
    private String email;
    @CsvBindByName
    private String phone;
    @CsvBindByName
    private  String country;
    // setter method
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPhoneNo(String phoneNo) {
        this.phone = phoneNo;
    }
    // getter methods
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNo() {
        return phone;
    }
    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return "CSVUser{"+
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}