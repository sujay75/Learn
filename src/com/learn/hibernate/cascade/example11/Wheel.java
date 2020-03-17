package com.learn.hibernate.cascade.example11;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wheel {


    /**
     * if @GenereatedValue not mentioned we get
     * javax.persistence.PersistenceException: org.hibernate.exception.ConstraintViolationException:
     * could not execute statement , parent key not found
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int wheelId;

    public int getWheelId() {
        return wheelId;
    }

    public void setWheelId(int wheelId) {
        this.wheelId = wheelId;
    }

    public String getWheelName() {
        return wheelName;
    }

    public void setWheelName(String wheelName) {
        this.wheelName = wheelName;
    }

    private String wheelName;
}
