package com.xworkz.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_tb")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    private String name;
    private String department;
    private double salary;
}
