package com.learn.hibernate.cascade.example11;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int               id;

    private String            carName;

    /*
     * If we are not using cascade both the objects need to be persist independently.How many collection
     * objects are there all should be saved seperately. If we are not using cascade and saving only Car object
     * then Hibernate will throw org.hibernate.TransientObjectException: object references an unsaved transient instance -
     * save the transient instance before flushing: com.learn.hibernate.cascade.example11.Wheel
     */
    @OneToMany(cascade = CascadeType.PERSIST)// while saving parent object should save all the child objects
    private Collection<Wheel> wheel = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Collection<Wheel> getWheel() {
        return wheel;
    }

    public void setWheel(Collection<Wheel> wheel) {
        this.wheel = wheel;
    }

}
