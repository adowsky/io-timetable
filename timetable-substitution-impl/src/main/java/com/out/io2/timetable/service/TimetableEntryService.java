package com.out.io2.timetable.service;

import com.out.io2.timetable.service.changeInPlan.ChangeInPlanService;
import com.out.io2.timetable.service.contact.ContactService;
import com.out.io2.timetable.service.group.GroupService;
import com.out.io2.timetable.service.lecturer.LecturerService;
import com.out.io2.timetable.service.lesson.LessonService;
import com.out.io2.timetable.service.model.*;
import com.out.io2.timetable.service.onCallTime.OnCallTimeService;
import com.out.io2.timetable.service.plan.PlanService;
import com.out.io2.timetable.service.planRow.PlanRowService;
import com.out.io2.timetable.service.rowInPlan.RowInPlanService;
import org.springframework.stereotype.Service;

@Service
public class TimetableEntryService {


    //private GroupService groupService;
    private LessonService lessonService;
    private PlanService planService;
    private PlanRowService planRowService;
    private RowInPlanService rowInPlanService;

    private Lesson lesson;
    private Plan plan;
    private PlanRow planRow;
    private RowInPlan rowInPlan;

    public TimetableEntryService(LessonService lessonService, PlanService planService, PlanRowService planRowService, RowInPlanService rowInPlanService) {
        this.lessonService = lessonService;
        this.planService = planService;
        this.planRowService = planRowService;
        this.rowInPlanService = rowInPlanService;
    }

    public void save(TimetableEntry entry) {
        generateConstructors(entry);
        lessonService.save(lesson);
        planService.save(plan);
        planRowService.save(planRow);
        rowInPlanService.save(rowInPlan);
    }

    private void generateConstructors(TimetableEntry entry) {
        lesson=new Lesson(null,entry.getSubject(),entry.getHour(),entry.getClassroom(),entry.getType());
        plan=new Plan(null,null,null);
        planRow=new PlanRow();
        rowInPlan=new RowInPlan();

    }
}
