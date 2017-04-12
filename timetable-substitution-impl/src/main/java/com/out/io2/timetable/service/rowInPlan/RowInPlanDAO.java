package com.out.io2.timetable.service.rowInPlan;

import javax.persistence.*;

@Entity
@Table(name = "row_in_plan")
public class RowInPlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "plan_plan_ID")
    private long planId;
    @Column(name = "plan_row_plan_row_ID")
    private long rowId;

    public RowInPlanDAO(long id,long planId, long rowId) {
        this.id=id;
        this.planId = planId;
        this.rowId = rowId;
    }

    public RowInPlanDAO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }
}
