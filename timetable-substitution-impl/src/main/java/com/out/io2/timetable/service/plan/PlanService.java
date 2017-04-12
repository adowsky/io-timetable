package com.out.io2.timetable.service.plan;

import com.out.io2.timetable.service.model.Plan;
import org.springframework.stereotype.Service;
@Service
public class PlanService {
private PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public void save(Plan plan) {
        PlanDAO dao = new PlanDAO(plan.getId(),plan.getSemester(), plan.getGroupID());
        planRepository.save(dao);
    }
}
