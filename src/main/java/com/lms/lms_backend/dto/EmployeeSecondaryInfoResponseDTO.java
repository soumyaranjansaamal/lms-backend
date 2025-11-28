package com.lms.lms_backend.dto;

import lombok.Data;

@Data
public class EmployeeSecondaryInfoResponseDTO {
    private Long id;
    private Long employeeId;
    private String maritalStatus;
    private String spouseName;
    private String emergencyContact;
    private String fatherName;
    private String motherName;
    private String bloodGroup;
    private String nationality;
    private String religion;
}