package com.out.io2.timetable.service.lecturer;


import com.out.io2.timetable.service.model.Lecturer;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Long, Lecturer> findByIds(Collection<Long> ids) {
        return ids.stream().map(id -> lecturerRepository.findOne(id))
                .map(dao -> new Lecturer(dao.getId(), dao.getName(),dao.getSurname(), dao.getAcademicTitle()))
                .collect(Collectors.toMap(Lecturer::getId, l -> l));
    }
}
