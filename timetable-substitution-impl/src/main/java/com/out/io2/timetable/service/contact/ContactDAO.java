package com.out.io2.timetable.service.contact;

import javax.annotation.*;
import javax.persistence.*;

/**
 * Created by Ania on 2017-04-12.
 */


@Entity
@Table(name="contact")

public class ContactDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "Teacher_teacher_ID")
    private long teacherId;

    ContactDAO(String email, long phoneNumber, long teacherId) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
    }

    public ContactDAO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getTeacherID() {
        return teacherId;
    }

    public void setTeacherID(long teacherId) {
        this.teacherId = teacherId;
    }
}