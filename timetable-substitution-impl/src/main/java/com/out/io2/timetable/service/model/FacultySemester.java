package com.out.io2.timetable.service.model;

import java.util.List;

public class FacultySemester {
    private int semester;
    private List<String> groups;

    public FacultySemester(int semester, List<String> groups) {
        this.semester = semester;
        this.groups = groups;
    }

    public int getSemester() {
        return semester;
    }

    public List<String> getGroups() {
        return groups;
    }
}
