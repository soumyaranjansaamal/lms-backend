package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeSalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryInfoRepository extends JpaRepository<EmployeeSalaryInfo, Long> {

    /**
     * Find all salary records for a given employee id.
     * Useful for endpoints that return salary history or current salary.
     */
    List<EmployeeSalaryInfo> findByEmployeeId(Long employeeId);
}