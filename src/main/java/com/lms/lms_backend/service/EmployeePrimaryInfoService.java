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

    // Added aliases used by controllers (keeps backward compatibility)
    default Optional<EmployeePrimaryInfo> findById(Long id) {
        return getEmployeeById(id);
    }

    default Optional<EmployeePrimaryInfo> findByEmail(String email) {
        return getEmployeeByEmail(email);
    }

    default List<EmployeePrimaryInfo> findAll() {
        return getAllEmployees();
    }
}