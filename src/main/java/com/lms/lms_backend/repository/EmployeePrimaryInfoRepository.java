package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeePrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Long> {

    /**
     * Find employee by email (used by service layer).
     * Return Optional to express absence/presence explicitly.
     */
    Optional<EmployeePrimaryInfo> findByEmail(String email);

    /**
     * Convenience check if an email already exists.
     */
    boolean existsByEmail(String email);
}