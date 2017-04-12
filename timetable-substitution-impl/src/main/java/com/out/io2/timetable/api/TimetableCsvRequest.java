package com.out.io2.timetable.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"day", "week", "subject", "hour", "classroom", "type", "teacherId", "faculty", "degreeCourse", "group"})
public class TimetableCsvRequest {
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

    public TimetableCsvRequest(String day, String week, String subject, String hour, String classroom, String type, String teacherId, String faculty, String degreeCourse, String group) {
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

    public TimetableCsvRequest(){}

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

    public void setDay(String day) {
        this.day = day;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TimetableCsvRequest{" +
                "day='" + day + '\'' +
                ", week='" + week + '\'' +
                ", subject='" + subject + '\'' +
                ", hour='" + hour + '\'' +
                ", classroom='" + classroom + '\'' +
                ", type='" + type + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
