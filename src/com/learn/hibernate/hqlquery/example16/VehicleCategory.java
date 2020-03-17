package com.learn.hibernate.hqlquery.example16;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String categoryName;



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
