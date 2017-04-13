package com.out.io2.timetable.service.rowInPlan;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "row_in_plan")
public class RowInPlanDAO {
    @EmbeddedId
    private CompositeId id;

    RowInPlanDAO(Long planId, Long rowId) {
        id = new CompositeId(planId, rowId);
    }

    public RowInPlanDAO() {
    }


    public Long getPlanId() {
        return id.planId;
    }

    public void setPlanId(Long planId) {
        this.id.planId = planId;
    }

    public Long getRowId() {
        return id.rowId;
    }

    public void setRowId(Long rowId) {
        this.id.rowId = rowId;
    }

    @Embeddable
    static class CompositeId implements Serializable {
        @Column(name = "plan_plan_ID")
        private Long planId;
        @Column(name = "plan_row_plan_row_ID")
        private Long rowId;

        CompositeId(Long planId, Long rowId) {
            this.planId = planId;
            this.rowId = rowId;
        }

        public CompositeId() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CompositeId that = (CompositeId) o;

            if (!planId.equals(that.planId)) return false;
            return rowId.equals(that.rowId);
        }

        @Override
        public int hashCode() {
            int result = planId.hashCode();
            result = 31 * result + rowId.hashCode();
            return result;
        }
    }
}
