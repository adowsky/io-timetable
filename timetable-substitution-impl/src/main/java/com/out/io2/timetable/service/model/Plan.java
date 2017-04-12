package com.out.io2.timetable.service.model;

public class Plan {
    private final Long id;
    private final String semestr;
    private final long groupID;

    public Plan(Long id, String semestr, long groupID) {
        this.id = id;
        this.semestr = semestr;
        this.groupID = groupID;
    }

    public Long getId() {
        return id;
    }

    public String getSemestr() {
        return semestr;
    }

    public long getGroupID() {
        return groupID;
    }
}
