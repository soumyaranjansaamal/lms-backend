package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;

import java.util.List;

public interface EmployeePrimaryInfoService {
    EmployeePrimaryInfo saveEmployee(EmployeePrimaryInfo employee);
    EmployeePrimaryInfo getEmployeeById(Long id);
    List<EmployeePrimaryInfo> getAllEmployees();
    EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated);
    void deleteEmployee(Long id);
}