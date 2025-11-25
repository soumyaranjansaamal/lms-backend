package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeBankInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeBankInfoService {
    EmployeeBankInfo saveBank(EmployeeBankInfo bankInfo);
    List<EmployeeBankInfo> getAllByEmployeeId(Long employeeId);
    Optional<EmployeeBankInfo> getByEmployeeId(Long employeeId);
}