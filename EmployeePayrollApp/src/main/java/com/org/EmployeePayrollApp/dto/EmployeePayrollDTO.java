package com.org.EmployeePayrollApp.dto;

import lombok.*;
import javax.validation.constraints.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

//    @JsonFormat(pattern = "dd MMM yyyy")
//    @NotNull(message = "Start Date should not be Empty")
//    @PastOrPresent(message = "Start Date should be past date or today's date")
//    public LocalDate start;
}