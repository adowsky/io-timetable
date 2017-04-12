package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Group;
import org.springframework.stereotype.Service;
@Service
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public void save(Group group) {
        GroupDAO dao = new GroupDAO(group.getId(),group.getDepartment(),group.getFaculty(),group.getGroup_number(),group.getYear());
        groupRepository.save(dao);
    }
}
