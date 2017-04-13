package com.out.io2.timetable.service.model;

public class TimetableEntry {
    private String day;
    private String week;
    private String subject;
    private String hour;
    private String classroom;
    private String type;
    private String teacherId;
    private String faculty;
    private String degreeCourse;
    private String group;

    public TimetableEntry(String day, String week, String subject, String hour, String classroom, String type, String teacherId, String faculty, String degreeCourse, String group) {
        this.day = day;
        this.week = week;
        this.subject = subject;
        this.hour = hour;
        this.classroom = classroom;
        this.type = type;
        this.teacherId = teacherId;
        this.faculty = faculty;
        this.degreeCourse = degreeCourse;
        this.group = group;
    }

    public TimetableEntry() {
    }

    public String getDay() {
        return day;
    }

    public String getWeek() {
        return week;
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

    public String getTeacherId() {
        return teacherId;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDegreeCourse() {
        return degreeCourse;
    }

    public String getGroup() {
        return group;
    }
}
