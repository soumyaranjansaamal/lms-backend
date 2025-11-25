package com.lms.lms_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSecondaryCreateDTO {

    @NotNull
    private Long employeeId;

    private String fatherName;
    private String motherName;
    private String maritalStatus;
    private String nationality;
    private String panNumber;
    private String adharNumber;
}