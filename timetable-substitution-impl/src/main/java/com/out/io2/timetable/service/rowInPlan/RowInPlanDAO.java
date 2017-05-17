package com.out.io2.timetable.service.rowInPlan;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "row_in_plan")
public class RowInPlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "plan_plan_ID")
    private Long planId;
    @Column(name = "plan_row_plan_row_ID")
    private Long rowId;

    RowInPlanDAO(Long planId, Long rowId) {
        this.planId = planId;
        this.rowId =  rowId;
    }

    public RowInPlanDAO() {
    }

    public Long getId() {
        return id;
    }

    public Long getPlanId() {
        return planId;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }
}
