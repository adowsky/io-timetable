package com.out.io2.timetable.service.lesson;

import javax.persistence.*;
/**
 * Created by Ania on 2017-04-12.
 */
@Entity
@Table(name = "lesson")
public class LessonDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String subject;
    private String hour;
    private String classroom;
    private String type;
    @Column(name = "lesson_ID")
    private long lessonId;

    LessonDAO(String hour, String classroom, String type, long lessonId) {
        this.hour = hour;
        this.classroom = classroom;
        this.type = type;
        this.lessonId = lessonId;
    }

    public LessonDAO() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }
}
