package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeLeave;

import java.util.List;

public interface EmployeeLeaveService {
    EmployeeLeave saveLeave(EmployeeLeave leave);
    List<EmployeeLeave> getLeavesByEmployee(Long employeeId);
    EmployeeLeave approveLeave(Long leaveId);   // simple example
    EmployeeLeave rejectLeave(Long leaveId);
}