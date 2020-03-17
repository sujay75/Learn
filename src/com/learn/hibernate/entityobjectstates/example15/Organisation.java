package com.learn.hibernate.entityobjectstates.example15;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    projectId;

    private String orgName;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

}
