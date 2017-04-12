package com.out.io2.timetable.service.lecturer;

import javax.persistence.*;

@Entity
@Table(name = "lecturers")
public class LecturerDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    @Column(name = "academic_title")
    private String academicTitle;

    LecturerDAO(long id, String name, String surname, String academicTitle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.academicTitle = academicTitle;
    }

    public LecturerDAO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }
}
