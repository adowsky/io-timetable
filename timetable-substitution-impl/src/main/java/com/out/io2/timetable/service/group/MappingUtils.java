package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Faculty;
import com.out.io2.timetable.service.model.FacultySemester;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class MappingUtils {
    static List<Faculty> mapDaoToDomainModel(List<GroupDAO> daos) {
        return daos.stream().collect(Collectors.groupingBy(GroupDAO::getFaculty))
                .entrySet().stream()
                .map(MappingUtils::mapGroupDaoByFacultyToFaculty)
                .collect(Collectors.toList());
    }

    private static Faculty mapGroupDaoByFacultyToFaculty(Map.Entry<String, List<GroupDAO>> daoByFaculty) {
        List<FacultySemester> semesters = daoByFaculty.getValue().stream()
                .collect(Collectors.groupingBy(GroupDAO::getYear)).entrySet().stream()
                .map(entry -> new FacultySemester(entry.getKey(), groupDaoToGroupIdList(entry.getValue())))
                .collect(Collectors.toList());
        return new Faculty(daoByFaculty.getKey(), semesters);

    }

    private static List<String> groupDaoToGroupIdList(List<GroupDAO> daos) {
        return daos.stream().map(GroupDAO::getGroupNumber).collect(Collectors.toList());
    }

}
