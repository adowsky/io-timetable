package com.out.io2.timetable.service.plan;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class PlanDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_ID")
    private Long id;
    private String semester;
    @Column(name = "group_group_ID")
    private Long groupID;

    PlanDAO(Long id,String semester, Long groupID) {
        this.semester = semester;
        this.groupID = groupID;
        this.id=id;
    }

    public PlanDAO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }
}
