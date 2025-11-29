package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {
    boolean existsByEmail(String email);
}