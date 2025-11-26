package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EmployeeExperience;

import java.util.List;
import java.util.Optional;

public interface EmployeeExperienceService {
    EmployeeExperience saveExperience(EmployeeExperience experience);
    List<EmployeeExperience> getByEmployeeId(Long employeeId);
    Optional<EmployeeExperience> getById(Long id);
}