package com.out.io2.timetable.controllers;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ControllersConfigurationTest {

    @Test
    public void shouldReturnConverterSupportsCsv() {
        //given
        ControllersConfiguration controllersConfiguration = new ControllersConfiguration();

        //when
        HttpMessageConverters converters = controllersConfiguration.customConverters();

        //then
        List<HttpMessageConverter> messageConvertersList = converters.getConverters().stream().filter(c -> c.getSupportedMediaTypes()
                .contains(MediaType.valueOf("text/csv")))
                .collect(Collectors.toList());
        Assertions.assertThat(messageConvertersList).hasAtLeastOneElementOfType(HttpMessageConverter.class);
    }
}