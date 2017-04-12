package com.out.io2.timetable.service.model;


public class ChangeInPlan {
    private final Long changeInPlanId;
    private final String oldDate;
    private final String newDate;
    private final Long lesson_Id;
    private final Long teacherId;
    private final Long planRowId;

    public ChangeInPlan(long changeInPlanId, String oldDate, String newDate, long lesson_Id, long teacherId, Long planRowId) {
        this.changeInPlanId = changeInPlanId;
        this.oldDate = oldDate;
        this.newDate = newDate;
        this.lesson_Id = lesson_Id;
        this.teacherId = teacherId;
        this.planRowId = planRowId;
    }

    public long getChangeInPlanId() {
        return changeInPlanId;
    }

    public String getOldDate() {
        return oldDate;
    }

    public String getNewDate() {
        return newDate;
    }

    public long getLesson_Id() {
        return lesson_Id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public Long getPlanRowId() {
        return planRowId;
    }
}
