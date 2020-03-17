package com.learn.hibernate.manytoone.mapping.example8;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Productt {

    @Id
    @GeneratedValue
    private Integer pid;

    private String  pname;

    @ManyToOne
    private Customerr customer;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Customerr getCustomer() {
        return customer;
    }

    public void setCustomer(Customerr customer) {
        this.customer = customer;
    }
}
