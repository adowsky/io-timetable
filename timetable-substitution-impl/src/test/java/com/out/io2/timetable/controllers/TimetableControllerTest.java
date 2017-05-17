package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.DepartmentResource;
import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.service.TimetableEntryService;
import com.out.io2.timetable.service.group.DepartmentService;
import com.out.io2.timetable.service.model.Department;
import com.out.io2.timetable.service.model.Faculty;
import com.out.io2.timetable.service.model.RowEntry;
import com.out.io2.timetable.service.model.TimetableEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimetableControllerTest {
    @Mock
    private TimetableEntryService timetableEntryService;
    @Mock
    private DepartmentService departmentService;
    @InjectMocks
    private TimetableController controller;

    @Test
    public void shouldReturnListWithDepartmentNames() {
        //given
        List<String> names = Arrays.asList("Name 1", "Name 2");
        when(departmentService.getDepartmentNames()).thenReturn(names);

        //when
        ResponseEntity<List<String>> actual = controller.getDepartments();

        //then
        assertThat(actual.getBody()).isEqualTo(names);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnResponseWithEmptyList() {
        //given
        when(departmentService.getDepartmentNames()).thenReturn(Collections.emptyList());

        //when
        ResponseEntity<List<String>> actual = controller.getDepartments();

        //then
        assertThat(actual.getBody()).isEmpty();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnDepartmentDetailsWithSingleFaculty() {
        //given
        String givenDepartmentName = "department";
        when(departmentService.getDepartmentDetails(givenDepartmentName)).thenReturn(createDepartment(givenDepartmentName, 1));

        //when
        ResponseEntity<DepartmentResource> departmentDetails = controller.getDepartmentDetails(givenDepartmentName);

        //then
        assertThat(departmentDetails.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(departmentDetails.getBody().getFaculties()).containsOnlyKeys("Faculty 0");
        assertThat(departmentDetails.getBody().getFaculties().get("Faculty 0")).isEmpty();
    }

    @Test
    public void shouldReturnDepartmentDetailsWithoutFaculties() {
        //given
        String givenDepartmentName = "department";
        when(departmentService.getDepartmentDetails(givenDepartmentName)).thenReturn(createDepartment(givenDepartmentName, 0));

        //when
        ResponseEntity<DepartmentResource> departmentDetails = controller.getDepartmentDetails(givenDepartmentName);

        //then
        assertThat(departmentDetails.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(departmentDetails.getBody().getFaculties()).hasSize(0);
    }

    @Test
    public void shouldAddNewEntry() {
        //given
        String department = "department";
        String faculty = "faculty";
        int semester = 2;
        String group = "Group 1";
        TimetableRequest givenRequest = givenTimetableRequest();
        ArgumentCaptor<TimetableEntry> captor = ArgumentCaptor.forClass(TimetableEntry.class);

        //when
        ResponseEntity actual = controller.addTimetableEntry(givenRequest, department, faculty, semester, group);

        //then
        assertThat(actual.getBody()).isNull();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(timetableEntryService).save(captor.capture());
        assertThat(captor.getValue()).isEqualToComparingFieldByField(expectedTimetableEntry(department, faculty, semester, group));
    }

    @Test
    public void shouldReturnTimetable() {
        //given
        String department = "department";
        String faculty = "faculty";
        int semester = 3;
        String group = "group";
        RowEntry rowEntry = new RowEntry("day", "week", "sir teacher", "sub", "h", "clss", "type");
        List<RowEntry> expectedReturn = Collections.singletonList(rowEntry);
        when(timetableEntryService.find(department, faculty, semester, group)).thenReturn(expectedReturn);

        //when
        ResponseEntity<List<RowEntry>> actual = controller.getTimetable(department, faculty, semester, group);

        //then
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actual.getBody()).containsOnly(rowEntry);
    }

    private TimetableRequest givenTimetableRequest() {
        List<TimetableCsvRequest> requests = Collections.singletonList(new TimetableCsvRequest(
                "day", "week", "subject", "hour", "classroom", "type", "id"));
        return new TimetableRequest(requests);
    }

    private TimetableEntry expectedTimetableEntry(String department, String faculty, int semester, String group) {
        return new TimetableEntry("day", "week", "subject", "hour", "classroom", "type", "id",
                department, faculty, group, semester);
    }

    private Department createDepartment(String departmentName, int facultiesCount) {
        List<Faculty> faculties = new ArrayList<>();
        for (int i = 0; i < facultiesCount; ++i) {
            faculties.add(new Faculty("Faculty " + i, Collections.emptyList()));
        }

        return new Department(departmentName, faculties);
    }
}