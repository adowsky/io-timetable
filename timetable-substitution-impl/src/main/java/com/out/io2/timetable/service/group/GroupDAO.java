package com.out.io2.timetable.service.group;

import javax.persistence.*;

@Entity
@Table(name = "students_group")
public class GroupDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long id;
    private String department;
    private String faculty;
    private int year;
    @Column(name = "group_number")
    private String groupNumber;

    public GroupDAO(Long id, String department, String faculty, String groupNumber, int year) {
        this.id=id;
        this.department = department;
        this.faculty = faculty;
        this.year = year;
        this.groupNumber = groupNumber;
    }

    public GroupDAO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}
