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

    private String employeeName;
    private String gender;
    private String dateOfBirth;
    private String qualification;
    private String email;
    private String phoneNumber;
}