package com.learn.hibernate.manytoone.mappedby.example9;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prodct {

    @Id
    @GeneratedValue
    private Integer pid;

    private String  pname;

    @ManyToOne
    @JoinColumn(name = "custom_id", nullable = false)
    private Custom  customerDetails;

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

    public Custom getCustomer() {
        return customerDetails;
    }

    public void setCustomer(Custom customerDetails) {
        this.customerDetails = customerDetails;
    }
}
