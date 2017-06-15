package com.out.io2.timetable.service.group;

import com.out.io2.timetable.service.model.Group;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GroupServiceTest {
    private final static String department = "dep";
    private final static String faculty = "fac";
    private final static int year = 3;
    private final static long id = 3L;
    private final static String number = "44";

    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private GroupService groupService;

    @Test
    public void shouldReturnEmptyOptional() {
        //given
        givenGroupRepository(new GroupDAO());

        //when
        Optional<Long> actual = groupService.getGroupId(department, faculty, year, number);

        //then
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    public void shouldReturnGroupId() {
        //given
        GroupDAO dao = new GroupDAO();
        dao.setId(1L);
        givenGroupRepository(dao);

        //when
        Optional<Long> actual = groupService.getGroupId(department, faculty, year, number);

        //then
        Assertions.assertThat(actual).contains(1L);
    }

    @Test
    public void shouldCallSave() {
        //when
        groupService.save(new Group(id, department, faculty, number, year));

        //then
        Mockito.verify(groupRepository).save(new GroupDAO(id, department, faculty, number, year));
    }

    private void givenGroupRepository(GroupDAO returnObj) {
        Mockito.when(groupRepository.findFirstByDepartmentAndFacultyAndYearAndGroupNumber(department,faculty,year,number))
                .thenReturn(returnObj);
    }

}