package com.lms.lms_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeCreateDTO {

    @NotBlank(message = "Employee name cannot be empty")
    private String employeeName;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "Date of birth is required (yyyy-MM-dd)")
    private String dateOfBirth;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;
}