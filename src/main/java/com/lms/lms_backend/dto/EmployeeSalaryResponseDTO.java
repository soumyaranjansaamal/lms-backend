package com.lms.lms_backend.dto;

import java.math.BigDecimal;

public class EmployeeSalaryResponseDTO {
    private Long id;
    private Long employeeId;
    private BigDecimal basic;
    private BigDecimal allowances;
    private BigDecimal deductions;
    private BigDecimal totalSalary;
    private Integer month;
    private Integer year;

    public EmployeeSalaryResponseDTO() {}

    // simple builder helper (optional but used earlier)
    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final EmployeeSalaryResponseDTO dto = new EmployeeSalaryResponseDTO();
        public Builder id(Long id){ dto.id = id; return this; }
        public Builder employeeId(Long employeeId){ dto.employeeId = employeeId; return this; }
        public Builder basic(BigDecimal basic){ dto.basic = basic; return this; }
        public Builder allowances(BigDecimal allowances){ dto.allowances = allowances; return this; }
        public Builder deductions(BigDecimal deductions){ dto.deductions = deductions; return this; }
        public Builder totalSalary(BigDecimal totalSalary){ dto.totalSalary = totalSalary; return this; }
        public Builder month(Integer month){ dto.month = month; return this; }
        public Builder year(Integer year){ dto.year = year; return this; }
        public EmployeeSalaryResponseDTO build(){ return dto; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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