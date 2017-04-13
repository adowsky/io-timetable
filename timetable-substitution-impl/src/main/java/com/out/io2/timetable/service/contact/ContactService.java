package com.out.io2.timetable.service.contact;

import com.out.io2.timetable.service.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void save(Contact contact){
        ContactDAO dao=new ContactDAO(contact.getContactId(),contact.getEmail(),contact.getPhoneNumber(),contact.getTeacherId());
        contactRepository.save(dao);
    }
}
