package com.lms.lms_backend.dto;

public class EmployeeLeaveResponseDTO {
    private Long id;
    private Long employeeId;
    private String leaveType;
    private Integer totalLeaves;
    private Integer usedLeaves;
    private Integer remainingLeaves;
    private Integer year;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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