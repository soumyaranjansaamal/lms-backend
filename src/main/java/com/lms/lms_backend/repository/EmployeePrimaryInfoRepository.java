package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {
    Optional<EmployeePrimaryInfo> findByEmail(String email);
}