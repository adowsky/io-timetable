package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.DepartmentResource;
import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.service.TimetableEntryService;
import com.out.io2.timetable.service.group.DepartmentService;
import com.out.io2.timetable.service.model.*;
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
     *
     * @param timetableRequest converted csv request
     * @return processing status
     */
    @PostMapping(value = "/departments/{department}/{faculty}/{semester}/{group}/timetable", consumes = "text/csv")
    ResponseEntity addTimetableEntry(@RequestBody @Valid TimetableRequest timetableRequest,
                                     @PathVariable String department, @PathVariable String faculty,
                                     @PathVariable int semester, @PathVariable String group) {
        timetableRequest.getTimetableCsvRequests()
                .forEach(request -> timetableEntryService.save(map(request, department, faculty, semester, group)));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private TimetableEntry map(TimetableCsvRequest request, String department, String faculty, int semester, String group) {
        return new TimetableEntry(request.getDay(), request.getWeek(), request.getSubject(), request.getHour(),
                request.getClassroom(), request.getType(), request.getTeacherId(), department,
                faculty, group, semester);

    }

    /**
     * Returns List with departments
     * @return List with departments
     */
    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<String>> getDepartments() {
        return ResponseEntity.ok(departmentService.getDepartmentNames());
    }


    /**
     * Returns details of department with given name
     * @param departmentName department name
     * @return details of department with given name
     */
    @GetMapping(value = "/departments/{departmentName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<DepartmentResource> getDepartmentDetails(@PathVariable String departmentName) {
        Department department = departmentService.getDepartmentDetails(departmentName);

        Map<String, Map<Integer, List<String>>> groupBySemesterByFaculty = department.getFaculties().stream()
                .collect(Collectors.toMap(Faculty::getName, e -> e.getSemesters().stream()
                        .collect(Collectors.toMap(FacultySemester::getSemester, FacultySemester::getGroups))));

        DepartmentResource departmentResource = new DepartmentResource(groupBySemesterByFaculty);
        return ResponseEntity.ok(departmentResource);
    }

    /**
     * Returns timetable for given parameters
     * @param department department name
     * @param faculty faculty name
     * @param semester semester
     * @param group group name
     * @return timetable for given parameters
     */

    @GetMapping(value = "/departments/{department}/{faculty}/{semester}/{group}/timetable", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<RowEntry>> getTimetable(@PathVariable String department, @PathVariable String faculty, @PathVariable int semester,
                                         @PathVariable String group) {
        List<RowEntry> rowEntries = timetableEntryService.find(department, faculty, semester, group);
        return ResponseEntity.ok(rowEntries);
    }

}
