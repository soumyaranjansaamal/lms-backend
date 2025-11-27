package com.lms.lms_backend.dto;

import java.time.LocalDate;

public class EmployeeResponseDTO {

    private Long id;
    private String employeeName;
    private String gender;
    private LocalDate dateOfBirth;
    private String qualification;
    private String email;
    private String phoneNumber;

    public EmployeeResponseDTO() {}

    public EmployeeResponseDTO(Long id, String employeeName, String gender, LocalDate dateOfBirth,
                               String qualification, String email, String phoneNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.qualification = qualification;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // getters
    public Long getId() { return id; }
    public String getEmployeeName() { return employeeName; }
    public String getGender() { return gender; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getQualification() { return qualification; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // builder to match your existing controller usage
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String employeeName;
        private String gender;
        private LocalDate dateOfBirth;
        private String qualification;
        private String email;
        private String phoneNumber;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder employeeName(String employeeName) { this.employeeName = employeeName; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder dateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public Builder qualification(String qualification) { this.qualification = qualification; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }

        public EmployeeResponseDTO build() {
            return new EmployeeResponseDTO(id, employeeName, gender, dateOfBirth, qualification, email, phoneNumber);
        }
    }
}