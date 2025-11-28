package com.lms.lms_backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

public class EmployeeSecondaryCreateDTO {

    @NotNull(message = "employeeId is required")
    @Positive(message = "employeeId must be positive")
    private Long employeeId;

    @NotBlank(message = "maritalStatus is required")
    @Size(max = 20)
    private String maritalStatus;

    @Size(max = 100)
    private String spouseName;

    // allow digits, +, -, spaces (very basic). Adjust regex if you want stricter validation.
    @Pattern(regexp = "^[0-9+\\-\\s]{7,20}$", message = "emergencyContact must be a valid phone number")
    private String emergencyContact;

    @NotBlank(message = "fatherName is required")
    @Size(max = 100)
    private String fatherName;

    @NotBlank(message = "motherName is required")
    @Size(max = 100)
    private String motherName;

    @Size(max = 5)
    private String bloodGroup;

    @Size(max = 50)
    private String nationality;

    @Size(max = 50)
    private String religion;

    // getters & setters

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getSpouseName() { return spouseName; }
    public void setSpouseName(String spouseName) { this.spouseName = spouseName; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }
}