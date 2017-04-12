package com.out.io2.timetable.service.rowInPlan;

import com.out.io2.timetable.service.model.RowInPlan;
import org.springframework.stereotype.Service;
@Service
public class RowInPlanService {
    private RowInPlanRepository rowInPlanRepository;

    public RowInPlanService(RowInPlanRepository rowInPlanRepository) {
        this.rowInPlanRepository = rowInPlanRepository;
    }
    public void save(RowInPlan rowInPlan) {
        RowInPlanDAO dao = new RowInPlanDAO(rowInPlan.getId(), rowInPlan.getPlanId(), rowInPlan.getRowId());
        rowInPlanRepository.save(dao);
    }
}
