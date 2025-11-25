package com.lms.lms_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSalaryCreateDTO {
    private Long employeeId;
    private double basic;
    private double allowances;
    private double deductions;
    private double totalSalary;
    private int month;
    private int year;
}