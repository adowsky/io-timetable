package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.LecturerRequest;
import com.out.io2.timetable.service.lecturer.LecturerService;
import com.out.io2.timetable.service.model.Lecturer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EntriesController {
    private LecturerService lecturerService;

    public EntriesController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @PostMapping("/lecturers")
    ResponseEntity saveLecturer(@RequestBody LecturerRequest lecturerRequest) {
        Lecturer lecturer = new Lecturer(null, lecturerRequest.getName(), lecturerRequest.getSurname(), lecturerRequest.getAcademicTitle());
        lecturerService.save(lecturer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
