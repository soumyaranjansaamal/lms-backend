package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeePrimaryInfoService {
    EmployeePrimaryInfo saveEmployee(EmployeePrimaryInfo employee);
    Optional<EmployeePrimaryInfo> findById(Long id);
    List<EmployeePrimaryInfo> findAll();
    void deleteEmployee(Long id);
    Optional<EmployeePrimaryInfo> findByEmail(String email);

    // new: update existing employee (returns updated entity)
    EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated);
}