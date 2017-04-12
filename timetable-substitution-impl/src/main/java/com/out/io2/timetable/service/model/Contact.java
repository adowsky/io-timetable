package com.out.io2.timetable.service.model;


public class Contact {
    private final Long contactId;
    private final String email;
    private final Long phoneNumber;
    private final Long teacherId;

    public Contact(Long contactId, String email, Long phoneNumber, Long teacherId) {
        this.contactId = contactId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.teacherId = teacherId;
    }

    public Long getContactId() {
        return contactId;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Long getTeacherId() {
        return teacherId;
    }
}
