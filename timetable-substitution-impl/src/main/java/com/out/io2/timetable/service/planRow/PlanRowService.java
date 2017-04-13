package com.out.io2.timetable.service.planRow;

import com.out.io2.timetable.service.model.PlanRow;
import org.springframework.stereotype.Service;

@Service
public class PlanRowService {
    private PlanRowRepository planRowRepository;

    public PlanRowService(PlanRowRepository planRowRepository) {
        this.planRowRepository = planRowRepository;
    }

    public Long save(PlanRow planRow) {
        PlanRowDAO dao = new PlanRowDAO(planRow.getId(), planRow.getWeek(), planRow.getDay(),planRow.getTeacherID(), planRow.getLessonID());
        dao = planRowRepository.save(dao);
        return dao.getId();

    }
}
