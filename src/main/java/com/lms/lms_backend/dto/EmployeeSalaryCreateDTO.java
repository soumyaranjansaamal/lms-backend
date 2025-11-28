package com.lms.lms_backend.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class EmployeeSalaryCreateDTO {

    @NotNull(message = "employeeId is required")
    @Positive(message = "employeeId must be positive")
    private Long employeeId;

    @NotNull(message = "basic is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "basic must be >= 0")
    private BigDecimal basic;

    @DecimalMin(value = "0.0", inclusive = true, message = "allowances must be >= 0")
    private BigDecimal allowances;

    @DecimalMin(value = "0.0", inclusive = true, message = "deductions must be >= 0")
    private BigDecimal deductions;

    // total may be computed server-side; mark optional if you compute it
    @DecimalMin(value = "0.0", inclusive = true, message = "totalSalary must be >= 0")
    private BigDecimal totalSalary;

    @Min(value = 1, message = "month must be between 1 and 12")
    @Max(value = 12, message = "month must be between 1 and 12")
    private Integer month;

    @Min(value = 1900, message = "year looks invalid")
    private Integer year;

    // getters & setters ...
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public BigDecimal getBasic() { return basic; }
    public void setBasic(BigDecimal basic) { this.basic = basic; }
    public BigDecimal getAllowances() { return allowances; }
    public void setAllowances(BigDecimal allowances) { this.allowances = allowances; }
    public BigDecimal getDeductions() { return deductions; }
    public void setDeductions(BigDecimal deductions) { this.deductions = deductions; }
    public BigDecimal getTotalSalary() { return totalSalary; }
    public void setTotalSalary(BigDecimal totalSalary) { this.totalSalary = totalSalary; }
    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}