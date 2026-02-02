package com.xworkz.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailsEntity {

    @Id
    private int id;
    private String studentName;
    private int age;
    private String course;
    private double fees;
}
