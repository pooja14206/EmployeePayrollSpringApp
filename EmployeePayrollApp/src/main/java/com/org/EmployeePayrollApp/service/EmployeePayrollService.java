package com.org.EmployeePayrollApp.service;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.org.EmployeePayrollApp.model.EmployeePayrollData;
import com.org.EmployeePayrollApp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(employeePayrollData);
        }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
       EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(employeePayrollData);
    }


    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empData);
    }
}
