package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Department;
import com.out.io2.timetable.service.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private GroupRepository groupRepository;

    public DepartmentService(GroupRepository departmentRepository) {
        this.groupRepository = departmentRepository;
    }

    public List<String> getDepartmentNames() {
        return groupRepository.getDistinctByDepartment().stream()
                .map(GroupDAO::getDepartment)
                .collect(Collectors.toList());
    }

    public Department getDepartmentDetails(String departmentName) {
        List<Faculty> faculties = groupRepository.getAllByDepartment(departmentName).stream()
                .collect(Collectors.groupingBy(GroupDAO::getFaculty)).entrySet().stream()
                .map(entity -> new Faculty(entity.getKey(), entity.getValue().stream()
                        .map(GroupDAO::getGroupNumber)
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());

        return new Department(departmentName, faculties);

    }
}
