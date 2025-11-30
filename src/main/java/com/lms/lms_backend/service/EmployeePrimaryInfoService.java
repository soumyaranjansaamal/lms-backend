package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeePrimaryInfoService {

    EmployeePrimaryInfo saveEmployee(EmployeePrimaryInfo employee);

    Optional<EmployeePrimaryInfo> getEmployeeById(Long id);

    Optional<EmployeePrimaryInfo> getEmployeeByEmail(String email);

    EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated);

    void deleteEmployee(Long id);

    List<EmployeePrimaryInfo> getAllEmployees();
}