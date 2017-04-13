package com.out.io2.timetable.service.lecturer;


import com.out.io2.timetable.service.model.Lecturer;
import org.springframework.stereotype.Service;

/**
 * Service that serves and saves lecturer data from and to remote repository.
 */
@Service
public class LecturerService {
    private LecturerRepository lecturerRepository;

    /**
     *
     * @param lecturerRepository remote repository interface
     */
    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    /**
     * Saves data to remote repository
     * @param lecturer lecturer data structure
     */
    public void save(Lecturer lecturer) {
        LecturerDAO dao = new LecturerDAO(lecturer.getId(), lecturer.getName(), lecturer.getSurname(), lecturer.getAcademicTitle());
        lecturerRepository.save(dao);
    }
}
