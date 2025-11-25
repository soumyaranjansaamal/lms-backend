package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeSecondaryInfo;

import java.util.List;

public interface EmployeeSecondaryInfoService {

    EmployeeSecondaryInfo save(EmployeeSecondaryInfo info);

    List<EmployeeSecondaryInfo> getByEmployeeId(Long employeeId);
}