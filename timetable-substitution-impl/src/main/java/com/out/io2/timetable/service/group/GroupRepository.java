package com.out.io2.timetable.service.group;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<GroupDAO, Long>{
    GroupDAO findFirstByFacultyAndGroupNumber(String faculty, String groupNumber);
    GroupDAO findFirstByDepartmentAndFacultyAndYearAndGroupNumber(String department, String faculty, int year, String groupNumber);
}
