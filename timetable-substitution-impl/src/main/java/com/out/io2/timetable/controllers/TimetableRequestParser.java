package com.out.io2.timetable.controllers;


import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.out.io2.timetable.api.TimetableCsvRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimetableRequestParser {

    public List<TimetableCsvRequest> parse(byte[] csvFile) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(TimetableCsvRequest.class).withHeader();
        ObjectReader reader = mapper.readerFor(TimetableCsvRequest.class).with(schema);

        return reader.readValues(csvFile).readAll().stream()
                .map(object -> (TimetableCsvRequest) object)
                .collect(Collectors.toList());
    }
}
