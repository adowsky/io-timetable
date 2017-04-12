package com.out.io2.timetable.service.model;

public class Plan {
    private final Long id;
    private final String semester;
    private final long groupID;

    public Plan(Long id, String semester, long groupID) {
        this.id = id;
        this.semester = semester;
        this.groupID = groupID;
    }

    public Long getId() {
        return id;
    }

    public String getSemester() {
        return semester;
    }

    public long getGroupID() {
        return groupID;
    }
}
