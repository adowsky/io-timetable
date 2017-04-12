package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.ModelObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TimetableController {

    @GetMapping("/my-endpoint/{myVar}")
    public ModelObject getMyEndpoint(@PathVariable String myVar) {

        return new ModelObject(myVar);
    }
}
