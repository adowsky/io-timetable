package com.out.io2.timetable.service.lecturer;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
class TeacherDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String degree;

    public TeacherDAO() {
    }

    TeacherDAO(String firstName, String lastName, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
