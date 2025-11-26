package com.lms.lms_backend.dto;

import lombok.*;

import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationCreateDTO {

    @NotNull
    private Long employeeId;

    @NotBlank
    private String degree;

    @NotBlank
    private String college;

    private Integer yearOfPassing;

    private String grade;
}