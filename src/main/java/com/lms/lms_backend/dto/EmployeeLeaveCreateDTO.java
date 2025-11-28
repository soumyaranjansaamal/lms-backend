package com.lms.lms_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeeLeaveCreateDTO {

    @NotNull
    @Positive(message = "employeeId must be positive")
    private Long employeeId;

    @NotBlank(message = "leaveType is required")
    private String leaveType;

    @NotNull
    @Min(value = 0, message = "totalLeaves must be >= 0")
    private Integer totalLeaves;

    @NotNull
    @Min(value = 0, message = "usedLeaves must be >= 0")
    private Integer usedLeaves;

    @NotNull
    @Min(value = 0, message = "remainingLeaves must be >= 0")
    private Integer remainingLeaves;

    @NotNull
    @Min(value = 2000, message = "year must be a valid year")
    private Integer year;

    // getters & setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public Integer getTotalLeaves() { return totalLeaves; }
    public void setTotalLeaves(Integer totalLeaves) { this.totalLeaves = totalLeaves; }

    public Integer getUsedLeaves() { return usedLeaves; }
    public void setUsedLeaves(Integer usedLeaves) { this.usedLeaves = usedLeaves; }

    public Integer getRemainingLeaves() { return remainingLeaves; }
    public void setRemainingLeaves(Integer remainingLeaves) { this.remainingLeaves = remainingLeaves; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}