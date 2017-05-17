package com.out.io2.timetable.service;

import com.out.io2.timetable.exceptions.NoSuchIdentifierException;
import com.out.io2.timetable.exceptions.NoSuchPlanException;
import com.out.io2.timetable.service.group.GroupService;
import com.out.io2.timetable.service.lecturer.LecturerService;
import com.out.io2.timetable.service.lesson.LessonService;
import com.out.io2.timetable.service.model.*;
import com.out.io2.timetable.service.plan.PlanService;
import com.out.io2.timetable.service.planRow.PlanRowService;
import com.out.io2.timetable.service.rowInPlan.RowInPlanService;
import com.out.io2.timetable.service.utils.DaysComparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Big Service to process timetable entries
 */
@Service
public class TimetableEntryService {
    private static final DaysComparator DAYS_COMPARATOR = new DaysComparator();

    private GroupService groupService;
    private LessonService lessonService;
    private PlanService planService;
    private PlanRowService planRowService;
    private RowInPlanService rowInPlanService;
    private LecturerService lecturerService;


    /**
     *
     * @param lessonService given lesson service
     * @param planService given plan service
     * @param planRowService given plan row service
     * @param rowInPlanService given row in plan service
     * @param groupService given group service
     */
    public TimetableEntryService(LessonService lessonService, PlanService planService, PlanRowService planRowService,
                                 RowInPlanService rowInPlanService, GroupService groupService, LecturerService lecturerService) {
        this.lessonService = lessonService;
        this.planService = planService;
        this.planRowService = planRowService;
        this.rowInPlanService = rowInPlanService;
        this.groupService = groupService;
        this.lecturerService = lecturerService;
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


    /**
     * Returns Timetable for given parameters
     * @param department department name
     * @param faculty faculty name
     * @param semester semester
     * @param group group
     * @return Timetable
     */
    public List<RowEntry> find(String department, String faculty, int semester, String group) {
        Long groupId = groupService.getGroupId(department, faculty, semester, group)
                .orElseThrow(() -> new NoSuchIdentifierException(String.format("Cannot find group with department=%s, faculty=%s, year=%d, group=%s ",
                        department, faculty, semester, group)));
        Long planId = planService.getPlanIdByGroup(groupId)
                .orElseThrow(() -> new NoSuchPlanException(String.format("Plan with id=%s not found", groupId)));
        List<Long> rowIds = rowInPlanService.findRowsByPlan(planId);
        List<PlanRow> rows = planRowService.getByIds(rowIds);
        Map<Long, List<PlanRow>> rowByTeacher = rows.stream().collect(Collectors.groupingBy(PlanRow::getTeacherID));
        Map<Long, List<PlanRow>> rowByLesson = rows.stream().collect(Collectors.groupingBy(PlanRow::getLessonID));
        Map<Long, Lecturer> lecturerById = lecturerService.findByIds(rowByTeacher.keySet());
        Map<Long, Lesson> lessonById = lessonService.getByIds(rowByLesson.keySet());

        return rows.stream().map(row -> new RowEntry(row.getDay(), row.getWeek(), lecturerToString(lecturerById.get(row.getTeacherID())),
                lessonById.get(row.getLessonID()).getSubject(), lessonById.get(row.getLessonID()).getHour(),
                lessonById.get(row.getLessonID()).getClassroom(), lessonById.get(row.getLessonID()).getType()))
        .sorted(Comparator.comparing(RowEntry::getDay, DAYS_COMPARATOR).thenComparing(RowEntry::getHour))
        .collect(Collectors.toList());

    }

    private String lecturerToString(Lecturer lecturer) {
        return new StringJoiner(" ")
                .add(lecturer.getAcademicTitle())
                .add(lecturer.getName())
                .add(lecturer.getSurname())
                .toString();
    }


}
