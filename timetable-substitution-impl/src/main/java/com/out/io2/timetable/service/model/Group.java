package com.out.io2.timetable.service.model;

public class Group {
    private final Long id;
    private final String department;
    private final String faculty;
    private final String group_number;
    private final int year;

    public Group(Long id, String department, String faculty, String group_number, int year) {
        this.id = id;
        this.department = department;
        this.faculty = faculty;
        this.group_number = group_number;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup_number() {
        return group_number;
    }

    public int getYear() {
        return year;
    }
}
