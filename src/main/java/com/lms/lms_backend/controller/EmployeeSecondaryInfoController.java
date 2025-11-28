package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryInfoResponseDTO;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employees/secondary-info")
public class EmployeeSecondaryInfoController {

    private final EmployeeSecondaryInfoService service;

    public EmployeeSecondaryInfoController(EmployeeSecondaryInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeSecondaryInfoResponseDTO> create(
            @Valid @RequestBody EmployeeSecondaryInfoCreateDTO dto) {

        EmployeeSecondaryInfoResponseDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/employees/secondary-info/" + created.getId()))
                .body(created);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeSecondaryInfoResponseDTO>> getByEmployee(
            @PathVariable @Positive(message = "employeeId must be positive") Long employeeId) {
        return ResponseEntity.ok(service.getByEmployeeId(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryInfoResponseDTO> getById(
            @PathVariable @Positive(message = "id must be positive") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryInfoResponseDTO> update(
            @PathVariable @Positive(message = "id must be positive") Long id,
            @Valid @RequestBody EmployeeSecondaryInfoCreateDTO dto) {

        EmployeeSecondaryInfoResponseDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive(message = "id must be positive") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}