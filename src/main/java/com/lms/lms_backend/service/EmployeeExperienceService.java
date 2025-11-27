package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeExperience;

import java.util.List;

public interface EmployeeExperienceService {
    EmployeeExperience saveExperience(EmployeeExperience experience);
    List<EmployeeExperience> getByEmployeeId(Long employeeId);
    EmployeeExperience getById(Long id);
    void deleteExperience(Long id);
}