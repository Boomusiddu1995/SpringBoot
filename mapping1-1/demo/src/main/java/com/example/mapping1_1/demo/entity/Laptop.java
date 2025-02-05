package com.example.mapping1_1.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="laptop")

public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lId;
    private String lName;
    @OneToOne
    private Student student;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
