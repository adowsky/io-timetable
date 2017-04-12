package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.service.TimetableEntryService;
import com.out.io2.timetable.service.model.TimetableEntry;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class TimetableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableController.class);

    private TimetableRequestParser timetableRequestParser;
    private DozerBeanMapper dozerBeanMapper;
    private TimetableEntryService timetableEntryService;


    public TimetableController(TimetableRequestParser timetableRequestParser, DozerBeanMapper dozerBeanMapper, TimetableEntryService entryService) {
        this.timetableRequestParser = timetableRequestParser;
        this.dozerBeanMapper = dozerBeanMapper;
        this.timetableEntryService = entryService;
    }

    @PostMapping(value = "/timetable")
    ResponseEntity getMyEndpoint(@RequestBody byte[] csvFile) throws IOException {
        List<TimetableCsvRequest> requests = timetableRequestParser.parse(csvFile);
        requests.forEach(request -> timetableEntryService.save(dozerBeanMapper.map(request, TimetableEntry.class)));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
