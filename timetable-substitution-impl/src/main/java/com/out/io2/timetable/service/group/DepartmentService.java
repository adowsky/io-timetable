package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Department;
import com.out.io2.timetable.service.model.Faculty;
import com.out.io2.timetable.service.model.FacultySemester;
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
        return groupRepository.getDistinctByDepartment();
    }

    public Department getDepartmentDetails(String departmentName) {
        List<Faculty> faculties = MappingUtils.mapDaoToDomainModel(groupRepository.getAllByDepartment(departmentName));
        return new Department(departmentName, faculties);

    }


}
