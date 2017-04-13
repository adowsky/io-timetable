package com.out.io2.timetable.service;

import com.out.io2.timetable.service.group.GroupService;
import com.out.io2.timetable.service.lesson.LessonService;
import com.out.io2.timetable.service.model.*;
import com.out.io2.timetable.service.plan.PlanService;
import com.out.io2.timetable.service.planRow.PlanRowService;
import com.out.io2.timetable.service.rowInPlan.RowInPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimetableEntryService {


    private GroupService groupService;
    private LessonService lessonService;
    private PlanService planService;
    private PlanRowService planRowService;
    private RowInPlanService rowInPlanService;


    public TimetableEntryService(LessonService lessonService, PlanService planService, PlanRowService planRowService, RowInPlanService rowInPlanService, GroupService groupService) {
        this.lessonService = lessonService;
        this.planService = planService;
        this.planRowService = planRowService;
        this.rowInPlanService = rowInPlanService;
        this.groupService = groupService;
    }

    @Transactional
    public void save(TimetableEntry entry) {
        Long lessonId = lessonService.save(new Lesson(null, entry.getSubject(), entry.getHour(), entry.getClassroom(), entry.getType()));
        Long groupId = groupService.getGroupId(entry.getFaculty(), entry.getGroup());

        Long planId = planService.getPlanIdByGroup(groupId)
                .orElseGet(() -> planService.save(new Plan(null, null, groupService.getGroupId(entry.getFaculty(), entry.getGroup()))));
        Long planRowId = planRowService.save(new PlanRow(null, entry.getDay(), entry.getWeek(), Long.valueOf(entry.getTeacherId()), lessonId));
        rowInPlanService.save(new RowInPlan( planRowId, planId));
    }


}
