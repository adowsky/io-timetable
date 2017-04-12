package com.out.io2.timetable.service.changeInPlan;

import javax.persistence.*;

/**
 * Created by Ania on 2017-04-12.
 */
@Entity
@Table(name = "change_in_plan")
public class ChangeInPlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String day;
    private String room;
    private String from;
    private String to;
    @Column(name = "teacher_teacher_ID")
    private long teacherId;

    ChangeInPlanDAO(String room, String from, String to, long teacherId) {
        this.room = room;
        this.from = from;
        this.to = to;
        this.teacherId = teacherId;
    }

    public ChangeInPlanDAO() {
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
