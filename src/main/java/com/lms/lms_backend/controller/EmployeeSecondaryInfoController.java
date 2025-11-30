package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/secondary")
public class EmployeeSecondaryInfoController {

    private final EmployeeSecondaryInfoService service;

    public EmployeeSecondaryInfoController(EmployeeSecondaryInfoService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<EmployeeSecondaryInfo> create(@Valid @RequestBody EmployeeSecondaryInfoDTO dto) {
        EmployeeSecondaryInfo created = service.create(dto);
        URI location = URI.create(String.format("/api/employees/secondary/%s", created.getId()));
        return ResponseEntity.created(location).body(created);
    }

    // Get by record id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryInfo> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get by employeeId
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<EmployeeSecondaryInfo> getByEmployeeId(@PathVariable Long employeeId) {
        return service.findByEmployeeId(employeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // List all
    @GetMapping
    public ResponseEntity<List<EmployeeSecondaryInfo>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryInfo> update(@PathVariable Long id,
                                                       @Valid @RequestBody EmployeeSecondaryInfoDTO dto) {
        EmployeeSecondaryInfo updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}