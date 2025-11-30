package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeTechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeTechnicalSkillRepository extends JpaRepository<EmployeeTechnicalSkill, Long> {
    List<EmployeeTechnicalSkill> findByEmployeeId(Long employeeId);
}