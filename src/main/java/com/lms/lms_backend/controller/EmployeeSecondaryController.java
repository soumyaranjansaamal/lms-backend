package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSecondaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryResponseDTO;
import com.lms.lms_backend.service.EmployeeSecondaryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/secondary-info")
public class EmployeeSecondaryController {

    private final EmployeeSecondaryService service;

    public EmployeeSecondaryController(EmployeeSecondaryService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<EmployeeSecondaryResponseDTO> create(@RequestBody @Valid EmployeeSecondaryCreateDTO dto) {
        EmployeeSecondaryResponseDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/employees/secondary-info/" + created.getId())).body(created);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryResponseDTO> getById(@PathVariable Long id) {
        EmployeeSecondaryResponseDTO dto = service.getById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    // Get all by employee id
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeSecondaryResponseDTO>> getByEmployee(@PathVariable Long employeeId) {
        List<EmployeeSecondaryResponseDTO> list = service.getByEmployeeId(employeeId);
        return ResponseEntity.ok(list);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSecondaryResponseDTO> update(@PathVariable Long id,
                                                               @RequestBody @Valid EmployeeSecondaryCreateDTO dto) {
        EmployeeSecondaryResponseDTO updated = service.update(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}