package com.learn.hibernate.inheritence.strategies.example12;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Appartment/Building")
public class Appartement extends House {

    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
    }

    private String builderName;
}
