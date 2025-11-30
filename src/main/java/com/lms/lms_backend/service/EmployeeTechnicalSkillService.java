package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;

import java.util.List;

public interface EmployeeTechnicalSkillService {
    EmployeeTechnicalSkillDTO addSkill(EmployeeTechnicalSkillDTO dto);
    List<EmployeeTechnicalSkillDTO> getSkillsForEmployee(Long employeeId);
    void deleteSkill(Long id);
}