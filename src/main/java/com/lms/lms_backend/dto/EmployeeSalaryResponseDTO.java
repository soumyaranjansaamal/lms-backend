package com.lms.lms_backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeSalaryResponseDTO {
    private Long id;
    private Long employeeId;
    private double basic;
    private double allowances;
    private double deductions;
    private double totalSalary;
    private int month;
    private int year;
}