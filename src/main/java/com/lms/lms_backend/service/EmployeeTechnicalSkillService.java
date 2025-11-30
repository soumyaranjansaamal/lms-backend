package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;
import com.lms.lms_backend.entity.EmployeeTechnicalSkill;

import java.util.List;
import java.util.Optional;

public interface EmployeeTechnicalSkillService {
    EmployeeTechnicalSkill create(EmployeeTechnicalSkillDTO dto);
    Optional<EmployeeTechnicalSkill> findById(Long id);
    List<EmployeeTechnicalSkill> findAllByEmployeeId(Long employeeId);
    EmployeeTechnicalSkill update(Long id, EmployeeTechnicalSkillDTO dto);
    void delete(Long id);
}