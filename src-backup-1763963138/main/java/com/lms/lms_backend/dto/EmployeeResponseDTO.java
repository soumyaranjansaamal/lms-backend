package com.lms.lms_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponseDTO {
    private Long id;
    private String employeeName;
    private String gender;
    private String dateOfBirth;
    private String qualification;
    private String email;
    private String phoneNumber;
}