package com.org.EmployeePayrollApp.repository;

import com.org.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
