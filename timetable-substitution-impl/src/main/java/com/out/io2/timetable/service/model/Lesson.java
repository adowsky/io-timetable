package com.out.io2.timetable.service.model;


public class Lesson {
    private final Long lessonId;
    private final String subject;
    private final String hour;
    private final String classroom;
    private final String type;

    public Lesson(Long lessonId, String subject, String hour, String classroom, String type) {
        this.lessonId = lessonId;
        this.subject = subject;
        this.hour = hour;
        this.classroom = classroom;
        this.type = type;
    }

    public Long getLessonId() {
        return lessonId;
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
