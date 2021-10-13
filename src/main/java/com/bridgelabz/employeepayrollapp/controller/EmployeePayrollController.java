package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * @purpose: Ability to get all the employees
     * @return: responseDTO
     */

    @GetMapping(value = "/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        log.info("Inside getEmployeePayrollData method");
        ResponseDTO respDTO = new ResponseDTO("Successfully get all employee", employeePayrollService.getEmployeePayrollData());
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * @purpose: Ability to get a enployee using their id
     * @param: empId
     * @return: responseDTO
     */

    @GetMapping(value = "/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        log.info("Inside getEmployeePayrollData method");
        ResponseDTO respDTO = new ResponseDTO("Successfully get employee by id", employeePayrollService.getEmployeePayrollDataById(empId));
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * @purpose: add new employee to the record
     * @param: employeePayrollDTO
     * @return: responseDTO
     */

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.info("Inside addEmployeePayrollData method");
        ResponseDTO respDTO = new ResponseDTO("Add new employee Successfully", employeePayrollService.createEmployeePayrollData(employeePayrollDTO));
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * @perpose: Update existion employee details
     * @param: empId
     * @param: employeePayrollDTO
     * @return: responseDTO
     */

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.info("Inside updateEmployeePayrollData method");
        ResponseDTO respDTO = new ResponseDTO("Update existing employee successfully", employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO));
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * @purpose: Ability to update employee details
     * @param: empId
     * @return: responseDTO
     */

    @DeleteMapping(value = "/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        log.info("Inside deleteEmployeePayrollData method");
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id:" + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * @purpose: Avility to get employee by department name
     * @param: department
     * @return: responseDTO
     */

    @GetMapping("/departmrnt/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable("department") String department) {
        log.info("Inside getEmployeePayrollDataByDepartment method");
        List<EmployeePayrollData> employeePayrollDataList;
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", employeePayrollService.getEmployeePayrollDataByDepartment(department));
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
}