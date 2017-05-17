package com.out.io2.timetable.service.rowInPlan;

import com.out.io2.timetable.service.model.RowInPlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that serves and saves row in plan data from and to remote repository.
 */
@Service
public class RowInPlanService {
    private RowInPlanRepository rowInPlanRepository;

    /**
     *
     * @param rowInPlanRepository remote repository
     */
    public RowInPlanService(RowInPlanRepository rowInPlanRepository) {
        this.rowInPlanRepository = rowInPlanRepository;
    }

    /**
     * Saves data to remote repository
     * @param rowInPlan given rowInPlan
     */
    public void save(RowInPlan rowInPlan) {
        RowInPlanDAO dao = new RowInPlanDAO(rowInPlan.getPlanId(), rowInPlan.getRowId());
        rowInPlanRepository.save(dao);
    }

    public List<Long> findRowsByPlan(Long planId) {
        return rowInPlanRepository.findAllByPlanId(planId).stream()
                .map(RowInPlanDAO::getRowId)
                .collect(Collectors.toList());
    }
}
