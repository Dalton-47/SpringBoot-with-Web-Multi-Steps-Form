package com.example.SpringbootWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Data
public class Students {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name = "studentId")
    private long studentId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name="secondName")
    private String secondName;

    @Column(name="course")
    private String course;

    @Column(name="fee")
    private double fee;


    // Constructors, getters, and setters


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}

