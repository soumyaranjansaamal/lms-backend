package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeTechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeTechnicalSkillRepository extends JpaRepository<EmployeeTechnicalSkill, Long> {
    List<EmployeeTechnicalSkill> findAllByEmployeeId(Long employeeId);
}