package com.lms.lms_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to primary employee record
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "religion")
    private String religion;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "address", length = 1000)
    private String address;

    public EmployeeSecondaryInfo() {}

    // simple convenience constructor (optional)
    public EmployeeSecondaryInfo(Long employeeId, String fatherName, String motherName,
                                 String spouseName, String maritalStatus, String religion,
                                 LocalDate dob, String address) {
        this.employeeId = employeeId;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.spouseName = spouseName;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.dob = dob;
        this.address = address;
    }

    // --- getters & setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getSpouseName() { return spouseName; }
    public void setSpouseName(String spouseName) { this.spouseName = spouseName; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}