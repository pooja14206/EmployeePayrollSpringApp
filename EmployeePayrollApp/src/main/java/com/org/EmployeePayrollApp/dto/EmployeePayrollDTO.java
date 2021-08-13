package com.org.EmployeePayrollApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class EmployeePayrollDTO {
    private String name;
    private long salary;
}
