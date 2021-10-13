package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "employee_payroll")
@Data
@AllArgsConstructor
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private long salary;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "PROFILE_PIC")
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "EMPLOYEE_DEPARTMENT", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "DEPARTMENT")
    private List<String> department;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.department = employeePayrollDTO.department;
    }
}