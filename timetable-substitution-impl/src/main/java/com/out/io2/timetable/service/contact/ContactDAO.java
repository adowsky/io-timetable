package com.out.io2.timetable.service.contact;

import javax.annotation.*;
import javax.persistence.*;




@Entity
@Table(name="contact")

public class ContactDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_ID")
    private long contactId;
    private String email;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "Teacher_teacher_ID")
    private long teacherId;

    ContactDAO(long contactId, String email, long phoneNumber, long teacherId) {
        this.contactId=contactId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
    }

    public ContactDAO() {
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
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

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}