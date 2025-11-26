package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeExperienceRepository extends JpaRepository<EmployeeExperience, Long> {
    List<EmployeeExperience> findByEmployeeId(Long employeeId);
}