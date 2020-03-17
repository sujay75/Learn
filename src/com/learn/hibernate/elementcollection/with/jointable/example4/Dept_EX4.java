package com.learn.hibernate.elementcollection.with.jointable.example4;

import javax.persistence.Embeddable;

@Embeddable
public class Dept_EX4 {

    public Dept_EX4() {
    }

    public Dept_EX4(String deptName, String deptBlock) {
        this.deptName = deptName;
        this.deptBlock = deptBlock;
    }

    private String deptName;
    private String deptBlock;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptBlock() {
        return deptBlock;
    }

    public void setDeptBlock(String deptBlock) {
        this.deptBlock = deptBlock;
    }
}
