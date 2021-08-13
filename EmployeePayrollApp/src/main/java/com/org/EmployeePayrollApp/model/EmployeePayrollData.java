package com.org.EmployeePayrollApp.model;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class EmployeePayrollData {

    private int empId;
    private String name;
    private long salary;

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        super();
        this.empId = empId;
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
    }
}