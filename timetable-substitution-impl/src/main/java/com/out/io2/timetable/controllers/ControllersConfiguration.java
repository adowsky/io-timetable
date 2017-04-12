package com.out.io2.timetable.controllers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebArgumentResolver;

import java.util.Collections;

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

    @Bean
    public HttpMessageConverters customConverters() {
        AbstractHttpMessageConverter<?> messageConverter = new TimetableCsvMessageConverter();
        MediaType mediaType = MediaType.valueOf("text/csv");
        messageConverter.setSupportedMediaTypes(Collections.singletonList(mediaType));
        return new HttpMessageConverters(messageConverter);
    }
}
