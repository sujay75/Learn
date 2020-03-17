package com.learn.hibernate.inheritence.strategies.example12;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// default Inheritance -single trable strategy being used : @Inheritance is optional

// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
// optinal : to overide the column name of Dtype use this.By default column name would be "DTYPE"
@DiscriminatorColumn(name = "HOUSE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    homeId;

    private String homeName;

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

}
