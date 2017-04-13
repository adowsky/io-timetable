package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Group;
import org.springframework.stereotype.Service;

/**
 * Service that serves and saves student groups data from and to remote repository.
 */
@Service
public class GroupService {
    private GroupRepository groupRepository;

    /**
     *
     * @param groupRepository interface to remote repository
     */
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /**
     * Saves given data into remote repository
     * @param group group data structure
     */
    public void save(Group group) {
        GroupDAO dao = new GroupDAO(group.getId(),group.getDepartment(),group.getFaculty(),group.getGroup_number(),group.getYear());
        groupRepository.save(dao);
    }

    /**
     * Finds group identifier for given data
     * @param faculty given faculty
     * @param number given number
     * @return group identifier for given data
     */
    public Long getGroupId(String faculty, String number) {
        GroupDAO dao =  groupRepository.findFirstByFacultyAndGroupNumber(faculty, number);
        return dao.getId();
    }
}
