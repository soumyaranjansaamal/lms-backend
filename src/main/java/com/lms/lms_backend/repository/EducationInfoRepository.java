package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationInfoRepository extends JpaRepository<EducationInfo, Long> {

    // Fetch all education records for a specific employee
    List<EducationInfo> findByEmployeeId(Long employeeId);
}