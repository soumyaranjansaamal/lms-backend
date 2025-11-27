package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    private String gender;
    private LocalDate dateOfBirth;
    private String qualification;
    private String email;
    private String phoneNumber;

    public EmployeePrimaryInfo() {}

    public EmployeePrimaryInfo(Long id, String employeeName, String gender, LocalDate dateOfBirth,
                               String qualification, String email, String phoneNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.qualification = qualification;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // small builder so controller code using EmployeePrimaryInfo.builder() works
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

        public EmployeePrimaryInfo build() {
            EmployeePrimaryInfo p = new EmployeePrimaryInfo();
            p.setId(id);
            p.setEmployeeName(employeeName);
            p.setGender(gender);
            p.setDateOfBirth(dateOfBirth);
            p.setQualification(qualification);
            p.setEmail(email);
            p.setPhoneNumber(phoneNumber);
            return p;
        }
    }
}