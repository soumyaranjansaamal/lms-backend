package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeContactInfoRepository extends JpaRepository<EmployeeContactInfo, Long> {
    List<EmployeeContactInfo> findByEmployeeId(Long employeeId);
}