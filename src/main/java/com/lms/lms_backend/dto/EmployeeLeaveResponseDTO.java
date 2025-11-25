package com.lms.lms_backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeLeaveResponseDTO {
    private Long id;
    private Long employeeId;
    private String leaveType;
    private int days;
    private String reason;
    private String status;
}