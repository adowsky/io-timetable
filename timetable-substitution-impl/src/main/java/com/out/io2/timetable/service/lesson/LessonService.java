package com.out.io2.timetable.service.lesson;

import com.out.io2.timetable.service.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Long, Lesson> getByIds(Collection<Long> ids) {
        return ids.stream().map(id -> lessonRepository.findOne(id))
                .map(dao -> new Lesson(dao.getLessonId(), dao.getSubject(), dao.getHour(), dao.getClassroom(), dao.getType()))
                .collect(Collectors.toMap(Lesson::getLessonId, l -> l));
    }
}
