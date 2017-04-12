package com.out.io2.timetable.service.planRow;

import javax.persistence.*;

@Entity
@Table(name = "plan_row")
public class PlanRowDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_row_ID")
    private long id;
    private String week;
    @Column(name = "day_of_the_week")
    private String day;
    @Column(name = "teacher_teacher_ID")
    private long teacherID;
    @Column(name = "lesson_lesson_ID")
    private long lessonID;

    public PlanRowDAO(long id,String week, String day, long teacherID, long lessonID) {
        this.week = week;
        this.day = day;
        this.teacherID = teacherID;
        this.lessonID = lessonID;
        this.id=id;
    }

    public PlanRowDAO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public long getLessonID() {
        return lessonID;
    }

    public void setLessonID(long lessonID) {
        this.lessonID = lessonID;
    }
}
