package com.out.io2.timetable.service.plan;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class PlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_ID")
    private long id;
    private String semester;
    @Column(name = "group_group_ID")
    private long groupID;

    public PlanDAO(long id,String semester, long groupID) {
        this.semester = semester;
        this.groupID = groupID;
        this.id=id;
    }

    public PlanDAO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }
}
