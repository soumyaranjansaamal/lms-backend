package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeSalary;

import java.util.List;

public interface EmployeeSalaryService {

    EmployeeSalary saveSalary(EmployeeSalary salary);

    List<EmployeeSalary> getSalaryByEmployee(Long employeeId);

    double getTotalSalary(Long employeeId);
}