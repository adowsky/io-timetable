package com.out.io2.timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Application launcher class
 */
@SpringBootApplication
public class TimetableApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(TimetableApplication.class, args);
    }
}
