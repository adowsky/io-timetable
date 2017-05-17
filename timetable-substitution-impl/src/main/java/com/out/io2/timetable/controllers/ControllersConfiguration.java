package com.out.io2.timetable.controllers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.out.io2.timetable.converters.TimetableCsvMessageConverter;
import com.out.io2.timetable.parers.TimetableRequestParser;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import java.util.Collections;


/**
 * Bean configuration for Spring application
 */
@Configuration
public class ControllersConfiguration {

    /**
     * Returns Csv Mapper
     * @return csv mapper
     */
    @Bean
    public CsvMapper csvMapper() {
        return new CsvMapper();
    }

    /**
     * Return additional http message converter which handles csv media type
     * @return http message converter supporting text/csv media type
     */
    @Bean
    public HttpMessageConverters customConverters() {
        AbstractHttpMessageConverter<?> messageConverter = new TimetableCsvMessageConverter(new TimetableRequestParser());
        MediaType mediaType = MediaType.valueOf("text/csv");
        messageConverter.setSupportedMediaTypes(Collections.singletonList(mediaType));
        return new HttpMessageConverters(messageConverter);
    }


}
