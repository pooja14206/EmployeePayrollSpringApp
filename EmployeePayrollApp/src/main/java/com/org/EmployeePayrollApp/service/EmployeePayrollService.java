package com.org.EmployeePayrollApp.service;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.org.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Liza",40000)));
        employeePayrollDataList.add(new EmployeePayrollData(2,new EmployeePayrollDTO("Moitry",80000)));
        employeePayrollDataList.add(new EmployeePayrollData(3,new EmployeePayrollDTO("Pooja",90000)));
        employeePayrollDataList.add(new EmployeePayrollData(4,new EmployeePayrollDTO("Kanika",50000)));
        return employeePayrollDataList;
    }


    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData employeeMatchWithId = null;
        employeeMatchWithId = new EmployeePayrollData(3,new EmployeePayrollDTO("Pooja",90000));
        return employeeMatchWithId;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newlyCreatedEmployee = null;
        newlyCreatedEmployee = new EmployeePayrollData(3,employeePayrollDTO);
        return newlyCreatedEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData updateEmployee = null;
        updateEmployee = new EmployeePayrollData(3,employeePayrollDTO);
        return updateEmployee;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
    }
}
