package com.lms.lms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LeaveCreateDTO {

    @NotNull(message = "employeeId is required")
    private Long employeeId;

    // yyyy-MM-dd
    @NotBlank(message = "startDate is required (yyyy-MM-dd)")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "startDate must be in yyyy-MM-dd format")
    private String startDate;

    @NotBlank(message = "endDate is required (yyyy-MM-dd)")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "endDate must be in yyyy-MM-dd format")
    private String endDate;

    @NotBlank(message = "type is required")
    @Size(max = 20)
    private String type;

    // status optional (when creating usually PENDING)
    private String status;

    @Size(max = 1000)
    private String reason;

    // getters / setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}