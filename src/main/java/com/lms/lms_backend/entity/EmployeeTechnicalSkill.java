package com.lms.lms_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_technical_skill")
public class EmployeeTechnicalSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to primary employee id (not a JPA relation to keep things simple)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @Column(name = "proficiency")
    private String proficiency; // e.g., Beginner / Intermediate / Expert

    @Column(name = "years_experience")
    private Double yearsExperience;

    public EmployeeTechnicalSkill() {}

    public EmployeeTechnicalSkill(Long employeeId, String skillName, String proficiency, Double yearsExperience) {
        this.employeeId = employeeId;
        this.skillName = skillName;
        this.proficiency = proficiency;
        this.yearsExperience = yearsExperience;
    }

    // --- getters & setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getProficiency() { return proficiency; }
    public void setProficiency(String proficiency) { this.proficiency = proficiency; }

    public Double getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(Double yearsExperience) { this.yearsExperience = yearsExperience; }
}