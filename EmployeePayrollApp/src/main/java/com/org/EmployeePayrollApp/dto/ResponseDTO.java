package com.org.EmployeePayrollApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    public String message;
    public Object data;
}
