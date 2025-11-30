package com.lms.lms_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeContactInfoDTO {
    private Long id;
    private Long employeeId;
    private String contactType;
    private String contactValue;
    private Boolean primaryContact;
}