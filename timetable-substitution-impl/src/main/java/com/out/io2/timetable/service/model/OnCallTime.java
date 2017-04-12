package com.out.io2.timetable.service.model;


public class OnCallTime {
    private final Long onCallTimeId;
    private final String day;
    private final String room;
    private final String from;
    private final String to;
    private final Long teacherId;

    public OnCallTime(Long onCallTimeId, String day, String room, String from, String to, Long teacherId) {
        this.onCallTimeId = onCallTimeId;
        this.day = day;
        this.room = room;
        this.from = from;
        this.to = to;
        this.teacherId = teacherId;
    }

    public Long getOnCallTimeId() {
        return onCallTimeId;
    }

    public String getDay() {
        return day;
    }

    public String getRoom() {
        return room;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Long getTeacherId() {
        return teacherId;
    }
}
