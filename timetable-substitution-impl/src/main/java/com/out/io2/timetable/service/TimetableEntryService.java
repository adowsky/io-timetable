package com.out.io2.timetable.service;

import com.out.io2.timetable.exceptions.NoSuchIdentifierException;
import com.out.io2.timetable.service.group.GroupService;
import com.out.io2.timetable.service.lesson.LessonService;
import com.out.io2.timetable.service.model.*;
import com.out.io2.timetable.service.plan.PlanService;
import com.out.io2.timetable.service.planRow.PlanRowService;
import com.out.io2.timetable.service.rowInPlan.RowInPlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Big Service to process timetable entries
 */
@Service
public class TimetableEntryService {
    private GroupService groupService;
    private LessonService lessonService;
    private PlanService planService;
    private PlanRowService planRowService;
    private RowInPlanService rowInPlanService;


    /**
     *
     * @param lessonService given lesson service
     * @param planService given plan service
     * @param planRowService given plan row service
     * @param rowInPlanService given row in plan service
     * @param groupService given group service
     */
    public TimetableEntryService(LessonService lessonService, PlanService planService, PlanRowService planRowService, RowInPlanService rowInPlanService, GroupService groupService) {
        this.lessonService = lessonService;
        this.planService = planService;
        this.planRowService = planRowService;
        this.rowInPlanService = rowInPlanService;
        this.groupService = groupService;
    }

    /**
     * Saves timetable entry to remote repository. Processed in transaction
     * @param entry given timetable entry
     */
    @Transactional
    public void save(TimetableEntry entry) {
        Long lessonId = lessonService.save(new Lesson(null, entry.getSubject(), entry.getHour(), entry.getClassroom(), entry.getType()));
        Long groupId = groupService.getGroupId(entry.getFaculty(), entry.getDegreeCourse(), entry.getYear(), entry.getGroup())
                .orElseThrow(() -> new NoSuchIdentifierException(String.format("Cannot find group with department=%s, faculty=%s, year=%d, group=%s ",
                        entry.getFaculty(), entry.getDegreeCourse(), entry.getYear(), entry.getGroup())));

        Long planId = planService.getPlanIdByGroup(groupId)
                .orElseGet(() -> planService.save(new Plan(null, String.valueOf(entry.getYear()), groupId)));

        Long planRowId = planRowService.save(new PlanRow(null, entry.getDay(), entry.getWeek(), Long.valueOf(entry.getTeacherId()), lessonId));
        rowInPlanService.save(new RowInPlan( planRowId, planId));
    }


}
