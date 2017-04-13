package com.out.io2.timetable.service.plan;

import com.out.io2.timetable.service.model.Plan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanService {
private PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Long save(Plan plan) {
        PlanDAO dao = new PlanDAO(plan.getId(),plan.getSemester(), plan.getGroupID());
        dao = planRepository.save(dao);
        return dao.getId();
    }

    public Optional<Long> getPlanIdByGroup(Long groupId) {
        return planRepository.findFirstByGroupID(groupId).map(PlanDAO::getGroupID);
    }
}
