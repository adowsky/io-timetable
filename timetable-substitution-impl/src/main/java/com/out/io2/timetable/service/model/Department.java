package com.out.io2.timetable.service.model;

import java.util.List;

public class Department {
    private String name;
    private List<Faculty> faculties;

    public Department(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}
