package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.service.LeaveService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/leave")
public class LeaveController {

    private final LeaveService service;

    public LeaveController(LeaveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeaveResponseDTO> create(@RequestBody @Valid LeaveCreateDTO dto) {
        LeaveResponseDTO created = service.save(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveResponseDTO> get(@PathVariable @Positive(message = "id must be positive") Long id) {
        LeaveResponseDTO dto = service.getById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<LeaveResponseDTO>> getByEmployee(@PathVariable @Positive(message = "employeeId must be positive") Long employeeId) {
        return ResponseEntity.ok(service.getByEmployee(employeeId));
    }

    @GetMapping("/by-start/{date}")
    public ResponseEntity<List<LeaveResponseDTO>> getByStartDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(service.getByStartDate(date));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveResponseDTO> update(@PathVariable @Positive(message = "id must be positive") Long id,
                                                   @RequestBody @Valid LeaveCreateDTO dto) {
        LeaveResponseDTO updated = service.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive(message = "id must be positive") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}