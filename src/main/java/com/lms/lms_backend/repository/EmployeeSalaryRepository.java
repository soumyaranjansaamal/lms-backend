package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Long> {

    List<EmployeeSalary> findByEmployeeId(Long employeeId);
}