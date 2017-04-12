package com.out.io2.timetable.service.model;

/**
 * Created by geral_000 on 2017-04-12.
 */
public class PlanRow {
    private final Long id;
    private final String day;
    private final String week;
    private final Long teacherID;
    private final Long lessonID;

    public PlanRow(Long id, String day, String week, Long teacherID, Long lessonID) {
        this.id = id;
        this.day = day;
        this.week = week;
        this.teacherID = teacherID;
        this.lessonID = lessonID;
    }

    public Long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getWeek() {
        return week;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public Long getLessonID() {
        return lessonID;
    }
}
