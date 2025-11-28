package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_leaves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;

    private String leaveType;   // Sick Leave, Casual Leave etc.
    private LocalDate startDate;
    private LocalDate endDate;

    private String reason;

    private String status; // PENDING / APPROVED / REJECTED
}