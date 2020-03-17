package com.learn.hibernate.hqlquery.namedquery.example17;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
@NamedQuery(name = "studentDetails.byId", query = "from StudentDetails where studentId=?1")
@NamedNativeQuery(name = "studentDetails.native.byId", query = "select * from student_details where studentname= ?", resultClass = StudentDetails.class)

public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int    studentId;

    private String studentName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
