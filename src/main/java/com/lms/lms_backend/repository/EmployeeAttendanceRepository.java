package com.lms.lms_backend.repository;

import com.lms.lms_backend.entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
    List<EmployeeAttendance> findByEmployeeId(Long employeeId);
    List<EmployeeAttendance> findByDate(LocalDate date);
}