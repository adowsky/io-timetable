package com.out.io2.timetable.service.lecturer;

import com.out.io2.timetable.service.model.Lecturer;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {
    private LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public void save(Lecturer lecturer) {
        LecturerDAO dao = new LecturerDAO(lecturer.getId(), lecturer.getName(), lecturer.getSurname(), lecturer.getAcademicTitle());
        lecturerRepository.save(dao);
    }
}
