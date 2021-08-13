package com.org.EmployeePayrollApp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeePayrollDTO {
    private String name;
    private long salary;
}
