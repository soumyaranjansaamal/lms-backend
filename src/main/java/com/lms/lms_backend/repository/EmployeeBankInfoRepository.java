package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeBankInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeBankInfoRepository extends JpaRepository<EmployeeBankInfo, Long> {
    List<EmployeeBankInfo> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeBankInfo> findFirstByEmployeeId(Long employeeId);
}