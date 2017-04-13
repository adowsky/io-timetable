package com.out.io2.timetable.service.planRow;

import javax.persistence.*;

@Entity
@Table(name = "plan_row")
public class PlanRowDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_row_ID")
    private Long id;
    private String week;
    @Column(name = "day_of_the_week")
    private String day;
    @Column(name = "teacher_teacher_ID")
    private Long teacherID;
    @Column(name = "lesson_lesson_ID")
    private Long lessonID;

    public PlanRowDAO(Long id,String week, String day, Long teacherID, Long lessonID) {
        this.week = week;
        this.day = day;
        this.teacherID = teacherID;
        this.lessonID = lessonID;
        this.id=id;
    }

    public PlanRowDAO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }

    public Long getLessonID() {
        return lessonID;
    }

    public void setLessonID(Long lessonID) {
        this.lessonID = lessonID;
    }
}
