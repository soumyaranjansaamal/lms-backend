package com.lms.lms_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeLeaveCreateDTO {
    private Long employeeId;
    private String leaveType;
    private int days;
    private String reason;
}