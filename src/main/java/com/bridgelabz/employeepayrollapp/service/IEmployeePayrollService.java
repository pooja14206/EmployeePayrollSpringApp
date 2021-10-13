package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    /**
     * @purpose: Ability to get all the employees
     * @return: responseDTO
     */

    List<EmployeePayrollData> getEmployeePayrollData();

    /**
     * @purpose: Ability to get a enployee using their id
     * @param: empId
     * @return: responseDTO
     */

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    /**
     * @purpose: add new employee to the record
     * @param: employeePayrollDTO
     * @return: responseDTO
     */

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    /**
     * @perpose: Update existion employee details
     * @param: empId
     * @param: employeePayrollDTO
     * @return: responseDTO
     */

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    /**
     * @purpose: Ability to update employee details
     * @param: empId
     * @return: responseDTO
     */

    void deleteEmployeePayrollData(int empId);

    /**
     * @purpose: Avility to get employee by department name
     * @param: department
     * @return: responseDTO
     */

    List<EmployeePayrollData> getEmployeePayrollDataByDepartment(String department);
}
