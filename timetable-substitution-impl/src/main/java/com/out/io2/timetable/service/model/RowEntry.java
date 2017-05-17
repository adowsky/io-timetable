package com.out.io2.timetable.service.model;

public class RowEntry {
    private final String day;
    private final String week;
    private final String teacher;
    private final String subject;
    private final String hour;
    private final String classroom;
    private final String type;

    public RowEntry(String day, String week, String teacher, String subject, String hour, String classroom, String type) {
        this.day = day;
        this.week = week;
        this.teacher = teacher;
        this.subject = subject;
        this.hour = hour;
        this.classroom = classroom;
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public String getWeek() {
        return week;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getHour() {
        return hour;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getType() {
        return type;
    }
}
