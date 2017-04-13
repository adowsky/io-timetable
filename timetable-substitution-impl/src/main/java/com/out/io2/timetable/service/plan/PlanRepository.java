package com.out.io2.timetable.service.plan;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanRepository extends CrudRepository<PlanDAO, Long>{
    Optional<PlanDAO> findFirstByGroupID(Long groupId);
}
