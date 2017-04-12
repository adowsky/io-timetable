package com.out.io2.timetable.service.model;

public class RowInPlan {
    private final Long id;
    private final Long rowId;
    private final Long planId;

    public RowInPlan(Long id, Long rowId, Long planId) {
        this.id = id;
        this.rowId = rowId;
        this.planId = planId;
    }

    public Long getId() {
        return id;
    }

    public Long getRowId() {
        return rowId;
    }

    public Long getPlanId() {
        return planId;
    }
}
