package com.out.io2.timetable.api;


public class LecturerRequest {
    private final String name;
    private final String surname;
    private final String academicTitle;

    public LecturerRequest(String name, String surname, String academicTitle) {
        this.name = name;
        this.surname = surname;
        this.academicTitle = academicTitle;
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
