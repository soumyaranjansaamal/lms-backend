package com.lms.lms_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_leaves")
public class EmployeeLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String leaveType;
    private Integer remainingLeaves;
    private Integer totalLeaves;
    private Integer usedLeaves;
    private Integer year;

    public EmployeeLeave() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public Integer getRemainingLeaves() { return remainingLeaves; }
    public void setRemainingLeaves(Integer remainingLeaves) { this.remainingLeaves = remainingLeaves; }

    public Integer getTotalLeaves() { return totalLeaves; }
    public void setTotalLeaves(Integer totalLeaves) { this.totalLeaves = totalLeaves; }

    public Integer getUsedLeaves() { return usedLeaves; }
    public void setUsedLeaves(Integer usedLeaves) { this.usedLeaves = usedLeaves; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}