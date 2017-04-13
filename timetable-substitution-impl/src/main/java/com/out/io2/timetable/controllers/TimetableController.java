package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.service.TimetableEntryService;
import com.out.io2.timetable.service.model.TimetableEntry;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Controller class that services request targeted to /api/ endpoints
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimetableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableController.class);

    private TimetableRequestParser timetableRequestParser;
    private DozerBeanMapper dozerBeanMapper;
    private TimetableEntryService timetableEntryService;


    TimetableController(TimetableRequestParser timetableRequestParser, DozerBeanMapper dozerBeanMapper, TimetableEntryService entryService) {
        this.timetableRequestParser = timetableRequestParser;
        this.dozerBeanMapper = dozerBeanMapper;
        this.timetableEntryService = entryService;
    }

    /**
     * Processes data given from request. Adds timetable entry to database
     * @param timetableRequest converted csv request
     * @return processing status
     */
    @PostMapping(value = "/timetable", consumes = "text/csv")
    ResponseEntity timetableEntryAdd(@RequestBody @Valid TimetableRequest timetableRequest) {
        timetableRequest.getTimetableCsvRequests().forEach(request -> timetableEntryService.save(map(request)));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private TimetableEntry map(TimetableCsvRequest request) {
        return new TimetableEntry(request.getDay(), request.getWeek(), request.getSubject(), request.getHour(), request.getClassroom(), request.getType(), request.getTeacherId(), request.getFaculty(), request.getDegreeCourse(), request.getGroup());

    }

}
