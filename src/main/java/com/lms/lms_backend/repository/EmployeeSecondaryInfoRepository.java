package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeSecondaryInfoRepository extends JpaRepository<EmployeeSecondaryInfo, Long> {

    Optional<EmployeeSecondaryInfo> findByEmployeeId(Long employeeId);

    boolean existsByEmployeeId(Long employeeId);
}