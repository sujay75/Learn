package com.learn.hibernate.cache.example19;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable // should be used for second level cache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)// should be used for second level cache
public class LecturerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    lecId;

    private String lectName;

    public int getLecId() {
        return lecId;
    }

    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    public String getLectName() {
        return lectName;
    }

    public void setLectName(String lectName) {
        this.lectName = lectName;
    }


}
