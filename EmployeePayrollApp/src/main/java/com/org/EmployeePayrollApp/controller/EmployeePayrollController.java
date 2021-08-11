package com.org.EmployeePayrollApp.controller;

import com.org.EmployeePayrollApp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    //curl localhost:8080/employeepayrollservice/get -w "\n"
    @GetMapping("/get")
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success.", HttpStatus.OK);
    }

    //curl localhost:8080/employeepayrollservice/get/1 -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Get Call Success for id:"+empId,HttpStatus.OK);
    }

    //http://localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<String>("Created Employee payroll data for:"+employeePayrollDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<String>("Updated Employee payroll Data for: "+employeePayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete Call Success for id: "+empId,HttpStatus.OK);
    }
}

