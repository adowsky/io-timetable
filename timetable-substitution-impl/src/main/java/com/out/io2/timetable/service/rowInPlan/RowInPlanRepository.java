package com.out.io2.timetable.service.rowInPlan;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RowInPlanRepository extends CrudRepository<RowInPlanDAO, Long> {
    List<RowInPlanDAO> findAllByPlanId(Long planId);
}
