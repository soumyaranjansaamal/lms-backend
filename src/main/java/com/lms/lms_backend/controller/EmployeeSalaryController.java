package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;
import com.lms.lms_backend.service.EmployeeSalaryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employees/salaries")
public class EmployeeSalaryController {

    private final EmployeeSalaryService service;

    public EmployeeSalaryController(EmployeeSalaryService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<EmployeeSalaryResponseDTO> createSalary(
            @Valid @RequestBody EmployeeSalaryCreateDTO dto
    ) {
        EmployeeSalaryResponseDTO saved = service.saveSalary(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // List by employee
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeSalaryResponseDTO>> getByEmployee(
            @PathVariable Long employeeId
    ) {
        List<EmployeeSalaryResponseDTO> list = service.getSalaryByEmployee(employeeId);
        return ResponseEntity.ok(list);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSalaryResponseDTO> getById(@PathVariable Long id) {
        EmployeeSalaryResponseDTO dto = service.getSalaryById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    // Total salary for employee
    @GetMapping("/total/{employeeId}")
    public ResponseEntity<BigDecimal> getTotalSalary(@PathVariable Long employeeId) {
        BigDecimal total = service.getTotalSalary(employeeId);
        if (total == null) total = BigDecimal.ZERO;
        return ResponseEntity.ok(total);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }
}