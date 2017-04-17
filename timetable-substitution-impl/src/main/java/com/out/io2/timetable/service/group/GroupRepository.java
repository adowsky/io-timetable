package com.out.io2.timetable.service.group;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupDAO, Long>{
    GroupDAO findFirstByFacultyAndGroupNumber(String faculty, String groupNumber);
    GroupDAO findFirstByDepartmentAndFacultyAndYearAndGroupNumber(String department, String faculty, int year, String groupNumber);
    List<GroupDAO> getDistinctByDepartment();
    List<GroupDAO> getAllByDepartment(String department);
}
