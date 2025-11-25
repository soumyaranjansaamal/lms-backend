package com.lms.lms_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_bank_info")
public class EmployeeBankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "ifsc", length = 50)
    private String ifsc;

    @Column(name = "bank_name", length = 200)
    private String bankName;

    @Column(name = "account_number", length = 64)
    private String accountNumber;

    public EmployeeBankInfo() {}

    public EmployeeBankInfo(Long id, Long employeeId, String ifsc, String bankName, String accountNumber) {
        this.id = id;
        this.employeeId = employeeId;
        this.ifsc = ifsc;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    // getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getIfsc() { return ifsc; }
    public void setIfsc(String ifsc) { this.ifsc = ifsc; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
}