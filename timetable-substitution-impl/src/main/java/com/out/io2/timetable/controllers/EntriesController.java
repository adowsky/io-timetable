package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.LecturerRequest;
import com.out.io2.timetable.service.lecturer.TeacherService;
import com.out.io2.timetable.service.model.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class EntriesController {
    private TeacherService teacherService;

    public EntriesController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/lecturers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity saveLecturer(@RequestBody LecturerRequest lecturerRequest) {
        Teacher teacher = new Teacher(null, lecturerRequest.getName(), lecturerRequest.getSurname(), lecturerRequest.getAcademicTitle());
        teacherService.save(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/lecturers/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Teacher> saveLecturer(@PathVariable long id) {
        Teacher teacher = teacherService.find(id);
        return ResponseEntity.ok(teacher);
    }
}
