package com.hy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by NeilHY on 2016/8/30.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "studentId")
    private Long id;

    @Column(nullable = false,unique = true)
    private Long phoneNumber;

    @Column(nullable = false,length = 20)
    private String studentName;

    @Column(nullable = false)
    private String college;

    @Column(nullable = false,length = 20)
    private String className;

    @Column(nullable = false)
    private Short grade;

    @Column(nullable = false)
    private String firstDpt;

    private String secondDpt;

    private Date signUpTime = new Date();

    private String selfIntroduction; //自我介绍

    private String honor;//获奖经历

    public Student() {
    }

    public Student(Long phoneNumber, String studentName, String college, String className, Short grade, String firstDpt, String secondDpt, Date signUpTime, String selfIntroduction, String honor) {
        this.phoneNumber = phoneNumber;
        this.studentName = studentName;
        this.college = college;
        this.className = className;
        this.grade = grade;
        this.firstDpt = firstDpt;
        this.secondDpt = secondDpt;
        this.signUpTime = new Date();
        this.selfIntroduction = selfIntroduction;
        this.honor = honor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getFirstDpt() {
        return firstDpt;
    }

    public void setFirstDpt(String firstDpt) {
        this.firstDpt = firstDpt;
    }

    public String getSecondDpt() {
        return secondDpt;
    }

    public void setSecondDpt(String secondDpt) {
        this.secondDpt = secondDpt;
    }

    public Date getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }
}
