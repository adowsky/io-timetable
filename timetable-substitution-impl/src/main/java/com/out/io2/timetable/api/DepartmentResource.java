package com.out.io2.timetable.api;

import java.util.List;
import java.util.Map;

public class DepartmentResource {
    private Map<String, Map<Integer, List<String>>> faculties;

    public DepartmentResource(Map<String, Map<Integer, List<String>>> faculties) {
        this.faculties = faculties;
    }


    public Map<String, Map<Integer, List<String>>> getFaculties() {
        return faculties;
    }
}
