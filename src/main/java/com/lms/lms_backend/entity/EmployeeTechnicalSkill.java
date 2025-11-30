package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_technical_skills_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeTechnicalSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relationship to employee primary
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeePrimaryInfo employee;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @Column(name = "proficiency") // optional: Beginner/Intermediate/Expert or numeric level
    private String proficiency;

    @Column(name = "years_experience")
    private Integer yearsExperience;
}