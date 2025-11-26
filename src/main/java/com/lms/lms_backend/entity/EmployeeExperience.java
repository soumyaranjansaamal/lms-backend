package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_experience")
public class EmployeeExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "company", length = 255)
    private String company;

    @Column(name = "role", length = 255)
    private String role;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "description", length = 2000)
    private String description;

    public EmployeeExperience() {}

    public EmployeeExperience(Long employeeId, String company, String role,
                              Integer startYear, Integer endYear, String description) {
        this.employeeId = employeeId;
        this.company = company;
        this.role = role;
        this.startYear = startYear;
        this.endYear = endYear;
        this.description = description;
    }

    // --- getters & setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Integer getStartYear() { return startYear; }
    public void setStartYear(Integer startYear) { this.startYear = startYear; }

    public Integer getEndYear() { return endYear; }
    public void setEndYear(Integer endYear) { this.endYear = endYear; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeExperience)) return false;
        EmployeeExperience that = (EmployeeExperience) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "EmployeeExperience{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}