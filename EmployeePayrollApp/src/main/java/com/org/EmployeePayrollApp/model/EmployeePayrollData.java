package com.org.EmployeePayrollApp.model;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String name;
    private String gender;
    private double salary;

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.empId = empId;
        this.name = employeePayrollDTO.name;
        this.gender = employeePayrollDTO.gender;
        this.salary = employeePayrollDTO.salary;
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.empId = empId;
        this.name = employeePayrollDTO.name;
        this.gender = employeePayrollDTO.gender;
        this.salary = employeePayrollDTO.salary;
//        this.start = employeePayrollDTO.start;
    }
}