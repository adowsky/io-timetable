package com.out.io2.timetable.service.planRow;

import com.out.io2.timetable.service.model.PlanRow;
import org.springframework.stereotype.Service;

/**
 * Service that serves and saves plan row data from and to remote repository.
 */
@Service
public class PlanRowService {
    private PlanRowRepository planRowRepository;

    /**
     *
     * @param planRowRepository remote repository
     */
    public PlanRowService(PlanRowRepository planRowRepository) {
        this.planRowRepository = planRowRepository;
    }

    /**
     * Saves data to remote repository and returns its identifier
     * @param planRow given planRow
     * @return remote repository id of given data
     */
    public Long save(PlanRow planRow) {
        PlanRowDAO dao = new PlanRowDAO(planRow.getId(), planRow.getWeek(), planRow.getDay(),planRow.getTeacherID(), planRow.getLessonID());
        dao = planRowRepository.save(dao);
        return dao.getId();

    }
}
