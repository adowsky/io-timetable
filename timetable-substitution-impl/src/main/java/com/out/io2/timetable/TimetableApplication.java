package com.out.io2.timetable;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.out.io2.timetable.api.TimetableCsvRequest;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TimetableApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TimetableApplication.class, args);
    }
}
