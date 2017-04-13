package com.out.io2.timetable.service.plan;

import com.out.io2.timetable.service.model.Plan;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service that serves and saves plan data from and to remote repository.
 */
@Service
public class PlanService {
    private PlanRepository planRepository;

    /**
     *
     * @param planRepository remote repository
     */
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    /**
     * Saves data to remote repository and returns its identifier
     *
     * @param plan plan data structure
     * @return remote repository id of given data
     */
    public Long save(Plan plan) {
        PlanDAO dao = new PlanDAO(plan.getId(), plan.getSemester(), plan.getGroupID());
        dao = planRepository.save(dao);
        return dao.getId();
    }

    /**
     * finds planId for given groupId
     *
     * @param groupId given groupId
     * @return groupId if exists
     */
    public Optional<Long> getPlanIdByGroup(Long groupId) {
        return planRepository.findFirstByGroupID(groupId).map(PlanDAO::getGroupID);
    }
}
