package com.out.io2.timetable.service.model;

public class RowInPlan {
    private final Long rowId;
    private final Long planId;

    public RowInPlan(Long rowId, Long planId) {
        this.rowId = rowId;
        this.planId = planId;
    }

    public Long getRowId() {
        return rowId;
    }

    public Long getPlanId() {
        return planId;
    }
}
