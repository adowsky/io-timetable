package com.out.io2.timetable.service.changeInPlan;

import com.out.io2.timetable.service.model.ChangeInPlan;


public class ChangeInPlanService {
private ChangeInPlanRepository changeInPlanRepository;

    public ChangeInPlanService(ChangeInPlanRepository changeInPlanRepository) {
        this.changeInPlanRepository = changeInPlanRepository;
    }

    public void save(ChangeInPlan changeInPlan){

        ChangeInPlanDAO dao=new ChangeInPlanDAO(changeInPlan.getChangeInPlanId(),changeInPlan.getOldDate(),changeInPlan.getNewDate(),changeInPlan.getLesson_Id(),changeInPlan.getTeacherId(),changeInPlan.getPlanRowId());
        changeInPlanRepository.save(dao);
    }
}
