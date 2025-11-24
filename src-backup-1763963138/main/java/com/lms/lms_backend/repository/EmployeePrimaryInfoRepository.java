package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {
    // you can add custom queries here later, e.g.
    // Optional<EmployeePrimaryInfo> findByEmail(String email);
}