package com.learn.hibernate.session.flush.merge.example21;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    pid;

    private String pName;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}
