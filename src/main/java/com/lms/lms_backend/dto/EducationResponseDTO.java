package com.lms.lms_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationResponseDTO {
    private Long id;
    private Long employeeId;
    private String degree;
    private String college;
    private Integer yearOfPassing;
    private String grade;
}