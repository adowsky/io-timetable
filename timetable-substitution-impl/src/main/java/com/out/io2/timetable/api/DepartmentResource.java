package com.out.io2.timetable.api;

import java.util.List;
import java.util.Map;

public class DepartmentResource {
    private String name;
    private Map<String, Map<Integer, List<String>>> faculties;

    public DepartmentResource(String name, Map<String, Map<Integer, List<String>>> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public Map<String, Map<Integer, List<String>>> getFaculties() {
        return faculties;
    }
}
