package com.org.EmployeePayrollApp.controller;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.org.EmployeePayrollApp.dto.ResponseDTO;
import com.org.EmployeePayrollApp.model.EmployeePayrollData;
import com.org.EmployeePayrollApp.service.IEmployeePayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    //Adding slf4j.
    Logger logger = LoggerFactory.getLogger(EmployeePayrollController.class);

    /*
     * Ability to Get All the employee form the list using GET Method.
     * Executing URL: localhost:8080/employeepayrollservice/get
     */

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        logger.trace("getEmployeePayrollData() method is running");
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /*
     * Ability to Get a specific employee form the list by Id using GET Method.
     * Executing URL: localhost:8080/employeepayrollservice/get/1
     * @param: empId.
     */

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        logger.trace("getEmployeePayrollDataById() method is running");
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get employee by Id Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Ability to insert new employee to the list using POST Method.
     * Executing URL: localhost:8080/employeepayrollservice/create
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        logger.trace("addEmployeePayrollData() method is running");
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create new employee Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Ability to update a employee from the list using PUT Method.
     * Executing URL: localhost:8080/employeepayrollservice/update/2
     * @param: empId.
     */

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO, @PathVariable int empId) {
        logger.trace("updateEmployeePayrollData() method is running");
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * Ability to delete a employee from the list using DELETE Method.
     * Executing URL: localhost:8080/employeepayrollservice/delete/2
     * @param: empId.
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        logger.trace("deleteEmployeePayrollData() method is running");
        return new ResponseEntity<String>("Delete Call Success for id: " + empId, HttpStatus.OK);
    }
}