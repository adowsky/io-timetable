package com.out.io2.timetable.controllers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.support.WebArgumentResolver;

@Configuration
public class ControllersConfiguration {

    @Bean
    public CsvMapper csvMapper() {
        return new CsvMapper();
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }
}
