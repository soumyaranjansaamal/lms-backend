package com.lms.lms_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeCreateDTO {

    @NotBlank(message = "Employee name cannot be empty")
    private String employeeName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Date of birth cannot be empty")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in format YYYY-MM-DD")
    private String dateOfBirth;

    @NotBlank(message = "Qualification cannot be empty")
    private String qualification;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;
}