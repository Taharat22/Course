package com.course.demo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Course{
    @Column
    @NotNull(message = "This can't be null")
    @Id
    private String courseCode;
    @Column
    private String title;
    @Column
    private  double credit;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title=" + title +
                ", credit=" + credit +
                '}';
    }
    public Course(){
        courseCode="";
        title="";
        credit=0.0;
    }
}