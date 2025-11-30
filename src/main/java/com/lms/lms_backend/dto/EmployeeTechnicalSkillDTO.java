package com.lms.lms_backend.dto;

public class EmployeeTechnicalSkillDTO {

    private Long id;
    private Long employeeId;
    private String skillName;
    private String proficiency;
    private Double yearsExperience;

    public EmployeeTechnicalSkillDTO() {}

    public EmployeeTechnicalSkillDTO(Long id, Long employeeId, String skillName, String proficiency, Double yearsExperience) {
        this.id = id;
        this.employeeId = employeeId;
        this.skillName = skillName;
        this.proficiency = proficiency;
        this.yearsExperience = yearsExperience;
    }

    // getters / setters
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