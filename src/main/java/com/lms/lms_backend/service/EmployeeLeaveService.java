package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeLeave;

import java.util.List;
import java.util.Optional;

public interface EmployeeLeaveService {
    EmployeeLeave saveLeave(EmployeeLeave leave);
    List<EmployeeLeave> getLeavesByEmployee(Long employeeId);
    Optional<EmployeeLeave> getLeaveById(Long id);
    void deleteLeave(Long id);
}