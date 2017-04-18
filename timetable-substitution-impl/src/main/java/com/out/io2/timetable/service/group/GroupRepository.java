package com.out.io2.timetable.service.group;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupDAO, Long>{
    GroupDAO findFirstByFacultyAndGroupNumber(String faculty, String groupNumber);
    GroupDAO findFirstByDepartmentAndFacultyAndYearAndGroupNumber(String department, String faculty, int year, String groupNumber);
    @Query("select distinct g.department from GroupDAO g")
    List<String> getDistinctByDepartment();
    List<GroupDAO> getAllByDepartment(String department);
}
