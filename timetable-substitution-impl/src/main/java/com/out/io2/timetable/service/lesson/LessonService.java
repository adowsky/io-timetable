package com.out.io2.timetable.service.lesson;

import com.out.io2.timetable.service.model.Lesson;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void save(Lesson lesson){
        LessonDAO dao=new LessonDAO(lesson.getSubject(),lesson.getHour(),lesson.getClassroom(),lesson.getType(),lesson.getLessonId());
        lessonRepository.save(dao);
    }
}
