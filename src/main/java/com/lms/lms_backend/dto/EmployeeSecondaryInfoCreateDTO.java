package com.lms.lms_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeSecondaryInfoCreateDTO {

    @NotNull(message = "employeeId is required")
    @Positive(message = "employeeId must be positive")
    private Long employeeId;

    // optional but allow blank
    private String maritalStatus;

    private String spouseName;

    // optional but when present must be 10 digits (adjust pattern if you want)
    @Pattern(regexp = "^$|^[0-9]{10}$", message = "emergencyContact must be 10 digits or empty")
    private String emergencyContact;

    @NotBlank(message = "fatherName is required")
    private String fatherName;

    private String motherName;

    private String bloodGroup;

    private String nationality;

    private String religion;
}