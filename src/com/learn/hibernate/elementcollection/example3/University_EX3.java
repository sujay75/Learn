package com.learn.hibernate.elementcollection.example3;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UNIVERSITY_EX3")
@Table(name = "UNIVERSITY")
public class University_EX3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "U_ID")
    private Integer   id;
    @Column(name = "U_NAME")
    private String    name;
    @ElementCollection
    private Set<Dept_EX3> deptList = new HashSet();

    public University_EX3() {
    }
    public University_EX3(int id, String name, Set<Dept_EX3> deptList) {
        this.id = id;
        this.name = name;
        this.deptList = deptList;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dept_EX3> getDeptList() {
        return deptList;
    }

    public void setDeptList(Set<Dept_EX3> deptList) {
        this.deptList = deptList;
    }

}
