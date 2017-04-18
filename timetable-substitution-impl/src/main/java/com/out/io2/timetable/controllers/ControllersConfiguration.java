package com.out.io2.timetable.controllers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.out.io2.timetable.converters.TimetableCsvMessageConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.Filter;
import java.util.Collections;
import java.util.stream.Collectors;

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

    @Bean
    public Filter loggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludePayload(true);
        filter.setIncludeQueryString(true);
        return filter;
    }


}
