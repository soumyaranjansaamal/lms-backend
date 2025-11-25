package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String fatherName;

    private String motherName;

    private String maritalStatus;

    private String nationality;

    private String panNumber;

    private String adharNumber;
}