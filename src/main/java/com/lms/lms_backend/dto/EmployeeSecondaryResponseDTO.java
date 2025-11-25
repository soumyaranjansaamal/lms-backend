package com.lms.lms_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSecondaryResponseDTO {
    private Long id;
    private Long employeeId;
    private String fatherName;
    private String motherName;
    private String maritalStatus;
    private String nationality;
    private String panNumber;
    private String adharNumber;
}