package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EducationInfo;

import java.util.List;

public interface EducationInfoService {

    // Create record
    EducationInfo saveEducation(EducationInfo education);

    // Get all education details for an employee
    List<EducationInfo> getEducationByEmployeeId(Long employeeId);
}