package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_contact_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeePrimaryInfo employee;

    @Column(name = "contact_type") // e.g., PHONE, EMERGENCY, ALT_EMAIL
    private String contactType;

    @Column(name = "contact_value")
    private String contactValue;

    @Column(name = "is_primary")
    private Boolean primaryContact;
}