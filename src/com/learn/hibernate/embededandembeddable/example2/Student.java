package com.learn.hibernate.embededandembeddable.example2;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String  name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "p_city")),
            @AttributeOverride(name = "state", column = @Column(name = "p_state")),
            @AttributeOverride(name = "country", column = @Column(name = "p_country"))
    })
    private Address pAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "c_city")),
            @AttributeOverride(name = "state", column = @Column(name = "c_state")),
            @AttributeOverride(name = "country", column = @Column(name = "c_country"))
    })
    private Address cAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getpAddress() {
        return pAddress;
    }

    public void setpAddress(Address pAddress) {
        this.pAddress = pAddress;
    }

    public Address getcAddress() {
        return cAddress;
    }

    public void setcAddress(Address cAddress) {
        this.cAddress = cAddress;
    }
}
