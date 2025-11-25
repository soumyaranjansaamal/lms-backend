package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeSalaryInfo;

import java.util.List;

public interface EmployeeSalaryInfoService {

    EmployeeSalaryInfo saveSalary(EmployeeSalaryInfo salaryInfo);

    List<EmployeeSalaryInfo> getAllSalaryByEmployee(Long employeeId);

    Double getTotalSalaryByEmployee(Long employeeId);
}