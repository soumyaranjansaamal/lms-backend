package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSecondaryRepository extends JpaRepository<EmployeeSecondaryInfo, Long> {
    List<EmployeeSecondaryInfo> findByEmployeeId(Long employeeId);
}