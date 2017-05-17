package com.out.io2.timetable.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.out.io2.timetable.commons.DefinedValues;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonPropertyOrder({"day", "week", "subject", "hour", "classroom", "type", "teacherId"})
public class TimetableCsvRequest {
    @DefinedValues(valueSet = {"PONIEDZIAŁEK", "WTOREK", "ŚRODA", "CZWARTEK", "PIĄTEK", "SOBOTA", "NIEDZIELA"})
    private String day;
    @DefinedValues(valueSet = {"PARZYSTY", "NIEPARZYSTY"})
    private String week;
    private String subject;
    @Pattern(regexp = "\\d+")
    private String hour;
    @NotNull
    @Size(min = 1)
    private String classroom;
    @DefinedValues(valueSet = {"WYKŁAD", "ĆWICZENIA", "LABORATORIA"})
    private String type;
    @Pattern(regexp = "\\d+")
    private String teacherId;

    public TimetableCsvRequest(String day, String week, String subject, String hour, String classroom, String type, String teacherId) {
        this.day = day;
        this.week = week;
        this.subject = subject;
        this.hour = hour;
        this.classroom = classroom;
        this.type = type;
        this.teacherId = teacherId;
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
