package com.out.io2.timetable.service.model;


import java.util.List;

public class Faculty {
    private List<String> groupIds;
    private String name;

    public Faculty(String name,List<String> groupIds) {
        this.groupIds = groupIds;
        this.name = name;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public String getName() {
        return name;
    }
}
