package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeSalaryService {
    EmployeeSalaryResponseDTO saveSalary(EmployeeSalaryCreateDTO dto);

    List<EmployeeSalaryResponseDTO> getSalaryByEmployee(Long employeeId);

    /**
     * Total salary (sum of totalSalary) for the given employee.
     */
    BigDecimal getTotalSalary(Long employeeId);

    void deleteSalary(Long id);

    /**
     * Return a salary record DTO by id. Returns null if not found (controller will handle 404).
     */
    EmployeeSalaryResponseDTO getSalaryById(Long id);
}