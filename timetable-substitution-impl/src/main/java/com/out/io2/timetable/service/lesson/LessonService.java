package com.out.io2.timetable.service.lesson;

import com.out.io2.timetable.service.model.Lesson;
import org.springframework.stereotype.Service;

/**
 * Service that serves and saves lesson data from and to remote repository.
 */
@Service
public class LessonService {
    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    /**
     * Saves data to remote repository and returns its identifier
     * @param lesson lesson data structure
     */
    public Long save(Lesson lesson) {
        LessonDAO dao = new LessonDAO(lesson.getSubject(), lesson.getHour(), lesson.getClassroom(), lesson.getType(), lesson.getLessonId());
        dao = lessonRepository.save(dao);
        return dao.getLessonId();
    }
}
