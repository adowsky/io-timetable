package com.out.io2.timetable.service.onCallTime;

import javax.persistence.*;


@Entity
@Table(name = "on-call_time")
public class OnCallTimeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "on-call_time_ID")
    private long onCallTimeId;
    private String day;
    private String room;
    private String from;
    private String to;
    @Column(name = "teacher_teacher_ID")
    private long teacherId;

    OnCallTimeDAO(long onCallTimeId, String room, String from, String to, long teacherId) {
        this.onCallTimeId=onCallTimeId;
        this.room = room;
        this.from = from;
        this.to = to;
        this.teacherId = teacherId;
    }

    public OnCallTimeDAO() {
    }

    public long getOnCallTimeId() {
        return onCallTimeId;
    }

    public void setOnCallTimeId(long onCallTimeId) {
        this.onCallTimeId = onCallTimeId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherID) {
        this.teacherId = teacherID;
    }
}
