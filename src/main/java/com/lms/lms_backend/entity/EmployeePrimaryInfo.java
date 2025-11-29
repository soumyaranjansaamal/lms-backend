package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity representing primary employee information.
 * Adjust column names / table name to match your DB if needed.
 */
@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Using the exact property names your service expects:
    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    // ------ Constructors ------

    public EmployeePrimaryInfo() {}

    public EmployeePrimaryInfo(String employeeName, String gender, LocalDate dateOfBirth,
                               String qualification, String phoneNumber, String email) {
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.qualification = qualification;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // ------ Getters & Setters (exact names used by service) ------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}