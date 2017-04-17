package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.DepartmentResource;
import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.service.TimetableEntryService;
import com.out.io2.timetable.service.group.DepartmentService;
import com.out.io2.timetable.service.model.Department;
import com.out.io2.timetable.service.model.Faculty;
import com.out.io2.timetable.service.model.TimetableEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller class that services request targeted to /api/ endpoints
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TimetableController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableController.class);

    private TimetableEntryService timetableEntryService;
    private DepartmentService departmentService;


    public TimetableController(TimetableEntryService timetableEntryService, DepartmentService departmentService) {
        this.timetableEntryService = timetableEntryService;
        this.departmentService = departmentService;
    }

    /**
     * Processes data given from request. Adds timetable entry to database
     * @param timetableRequest converted csv request
     * @return processing status
     */
    @PostMapping(value = "/departments/{department}/{faculty}/{semester}/{group}/timetable", consumes = "text/csv")
    ResponseEntity addTimetableEntry(@RequestBody @Valid TimetableRequest timetableRequest,
                                     @PathVariable String department, @PathVariable String faculty,
                                     @PathVariable int semester, @PathVariable String group) {
        timetableRequest.getTimetableCsvRequests()
                .forEach(request -> timetableEntryService.save(map(request, department,faculty, semester, group)));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private TimetableEntry map(TimetableCsvRequest request, String department, String faculty, int semester, String group) {
        return new TimetableEntry(request.getDay(), request.getWeek(), request.getSubject(), request.getHour(),
                request.getClassroom(), request.getType(), request.getTeacherId(), department,
                faculty, group, semester);

    }

    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<String>> getDepartments() {
        return ResponseEntity.ok(departmentService.getDepartmentNames());
    }

    @GetMapping(value = "/departments/{department}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<DepartmentResource> getDepartmentDetails(@PathVariable String departmentName) {
        Department department = departmentService.getDepartmentDetails(departmentName);
        Map<String, List<String>> groupsByFaculties = department.getFaculties().stream()
                .collect(Collectors.toMap(Faculty::getName, Faculty::getGroupIds));
        DepartmentResource departmentResource = new DepartmentResource(department.getName(), groupsByFaculties);
        return ResponseEntity.ok(departmentResource);
    }

}
