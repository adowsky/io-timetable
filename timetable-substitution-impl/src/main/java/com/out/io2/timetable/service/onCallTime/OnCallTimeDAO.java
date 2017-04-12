package com.out.io2.timetable.service.onCallTime;

import javax.persistence.*;

/**
 * Created by Ania on 2017-04-12.
 */
@Entity
@Table(name = "on_call_time")
public class OnCallTimeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "old_date")
    private String oldDate;
    @Column(name = "new_date")
    private String newDate;
    @Column(name = "change_in_plan_ID")
    private long changeInPlanID;
    @Column(name = "lesson_lesson_ID")
    private long lessonId;

    OnCallTimeDAO(String newDate, long changeInPlanID, long lessonId) {
        this.newDate = newDate;
        this.changeInPlanID = changeInPlanID;
        this.lessonId = lessonId;
    }

    public OnCallTimeDAO() {
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

    public long getChangeInPlanID() {
        return changeInPlanID;
    }

    public void setChangeInPlanID(long changeInPlanID) {
        this.changeInPlanID = changeInPlanID;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }
}
