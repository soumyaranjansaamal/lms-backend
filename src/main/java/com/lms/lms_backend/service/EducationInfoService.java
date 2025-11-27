package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EducationInfo;

import java.util.List;
import java.util.Optional;

public interface EducationInfoService {
    EducationInfo save(EducationInfo info);
    List<EducationInfo> getByEmployeeId(Long employeeId);
    Optional<EducationInfo> getById(Long id);
    void delete(Long id);
}