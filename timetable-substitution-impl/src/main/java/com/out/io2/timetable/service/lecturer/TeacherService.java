package com.out.io2.timetable.service.lecturer;

import com.out.io2.timetable.service.model.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void save(Teacher teacher) {
        TeacherDAO dao = new TeacherDAO(teacher.getName(), teacher.getSurname(), teacher.getAcademicTitle());
        teacherRepository.save(dao);
    }

    public Teacher find(long id) {
        TeacherDAO teacher = teacherRepository.findOne(id);
        return new Teacher(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getDegree());
    }

}
