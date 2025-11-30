package com.lms.lms_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeTechnicalSkillDTO {
    private Long id;
    private Long employeeId;
    private String skillName;
    private String proficiency;
    private Integer yearsExperience;
}