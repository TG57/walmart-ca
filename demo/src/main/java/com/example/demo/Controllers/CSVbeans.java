package com.example.demo.Controllers;

import java.io.*;
import java.util.UUID;

public class CSVbeans {
    String str;
    UUID uuid = UUID.randomUUID();
    public CSVbeans(String str) throws FileNotFoundException {
        this.str = str;
//        List<CSVobj> beans = new CsvToBeanBuilder(new FileReader(str))
//                .withType(CSVobj.class)
//                .build()
//                .parse();
//        //call cassandra insertion in 200 lines
//        beans.forEach(System.out::println);
    }

    public String getStr() {
        return str;
    }

    public String uuidAsString = uuid.toString();

    public String getId() {
        return uuidAsString;
    }
}


