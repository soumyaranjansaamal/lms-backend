package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;
import com.lms.lms_backend.service.EmployeeSalaryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/salaries")
public class EmployeeSalaryController {

    private final EmployeeSalaryService service;

    public EmployeeSalaryController(EmployeeSalaryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeSalaryResponseDTO> create(@Valid @RequestBody EmployeeSalaryCreateDTO dto) {
        // server: optionally compute totalSalary if not provided
        EmployeeSalaryResponseDTO saved = service.saveSalary(dto);
        return ResponseEntity.created(URI.create("/api/employees/salaries/" + saved.getId())).body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeSalaryResponseDTO>> byEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getSalaryByEmployee(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSalaryResponseDTO> get(@PathVariable Long id) {
        EmployeeSalaryResponseDTO dto = service.getSalaryById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }
}