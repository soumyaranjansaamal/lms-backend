package com.lms.lms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AttendanceCreateDTO {

    @NotNull(message = "employeeId is required")
    private Long employeeId;

    // Accepts yyyy-MM-dd
    @NotBlank(message = "date is required (yyyy-MM-dd)")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date must be in yyyy-MM-dd format")
    private String date;

    @NotBlank(message = "status is required")
    @Size(max = 1, message = "status should be single char like P/A")
    private String status;

    // Optional, but if provided must be HH:mm:ss
    @Pattern(regexp = "^$|^\\d{2}:\\d{2}:\\d{2}$", message = "inTime must be HH:mm:ss or empty")
    private String inTime;

    @Pattern(regexp = "^$|^\\d{2}:\\d{2}:\\d{2}$", message = "outTime must be HH:mm:ss or empty")
    private String outTime;

    private String remarks;

    // getters / setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getInTime() { return inTime; }
    public void setInTime(String inTime) { this.inTime = inTime; }

    public String getOutTime() { return outTime; }
    public void setOutTime(String outTime) { this.outTime = outTime; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}