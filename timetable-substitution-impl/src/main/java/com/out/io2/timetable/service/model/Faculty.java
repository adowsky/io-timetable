package com.out.io2.timetable.service.model;


import java.util.List;

public class Faculty {
    private List<FacultySemester> semesters;
    private String name;

    public Faculty(String name,List<FacultySemester> semesters) {
        this.semesters = semesters;
        this.name = name;
    }

    public List<FacultySemester> getSemesters() {
        return semesters;
    }

    public String getName() {
        return name;
    }
}
