package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_primary_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePrimaryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal details
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String gender;
    private String dateOfBirth;

    // Contact details
    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String alternatePhone;

    // Address
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;

    // Professional
    private String designation;
    private String department;
    private String employeeCode;

    // Optional fields for update
    private String bloodGroup;
    private String maritalStatus;
    private String nationality;
}