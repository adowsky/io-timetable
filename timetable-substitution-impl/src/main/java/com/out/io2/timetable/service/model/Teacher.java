package com.out.io2.timetable.service.model;


public class Teacher {
    private final Long id;
    private final String name;
    private final String surname;
    private final String academicTitle;

    public Teacher(Long id, String name, String surname, String academicTitle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.academicTitle = academicTitle;
    }

    public Teacher(Long id) {
        this(id, null, null, null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }
}
