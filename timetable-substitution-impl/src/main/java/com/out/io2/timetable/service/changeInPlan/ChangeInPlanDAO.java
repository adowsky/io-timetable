package com.out.io2.timetable.service.changeInPlan;

import javax.persistence.*;

@Entity
@Table(name = "change_in_plan")
public class ChangeInPlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "change_in_plan_ID")
    private long changeInPlanId;
    @Column(name = "old_date")
    private String oldDate;
    @Column(name = "new_date")
    private String newDate;
    @Column(name = "lesson_lesson_ID")
    private long lesson_Id;
    @Column(name = "teacher_teacher_ID")
    private long teacherId;
    @Column(name = "plan_row_plan_row_ID")
    private long planRowId;

    ChangeInPlanDAO(long changeInPlanId,String oldDate, String newDate, long lesson_Id, long teacherId, long planRowId) {
        this.changeInPlanId=changeInPlanId;
        this.oldDate = oldDate;
        this.newDate = newDate;
        this.lesson_Id = lesson_Id;
        this.teacherId = teacherId;
        this.planRowId = planRowId;
    }

    public ChangeInPlanDAO() {
    }

    public long getChangeInPlanId() {
        return changeInPlanId;
    }

    public void setChangeInPlanId(long changeInPlanId) {
        this.changeInPlanId = changeInPlanId;
    }

    public String getOldDate() {
        return oldDate;
    }

    public void setOldDate(String oldDate) {
        this.oldDate = oldDate;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public long getLesson_Id() {
        return lesson_Id;
    }

    public void setLesson_Id(long lesson_Id) {
        this.lesson_Id = lesson_Id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getPlanRowId() {
        return planRowId;
    }

    public void setPlanRowId(long planRowId) {
        this.planRowId = planRowId;
    }
}
