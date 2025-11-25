package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_leave")
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

    // e.g. "SICK", "CASUAL", "EARNED"
    private String leaveType;

    // number of days requested
    private int days;

    private String reason;

    // "PENDING", "APPROVED", "REJECTED"
    private String status;
}