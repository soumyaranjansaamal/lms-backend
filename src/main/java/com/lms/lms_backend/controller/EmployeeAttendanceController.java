package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {

    private final EmployeeAttendanceService service;

    public EmployeeAttendanceController(EmployeeAttendanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AttendanceResponseDTO> create(@RequestBody @Valid AttendanceCreateDTO dto) {
        AttendanceResponseDTO saved = service.save(dto);
        return ResponseEntity.created(null).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> getById(@PathVariable @Positive(message = "id must be positive") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByEmployee(
            @PathVariable @Positive(message = "employeeId must be positive") Long employeeId) {
        return ResponseEntity.ok(service.getByEmployeeId(employeeId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByDate(@PathVariable String date) {
        return ResponseEntity.ok(service.getByDate(java.time.LocalDate.parse(date)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> update(
            @PathVariable @Positive(message = "id must be positive") Long id,
            @RequestBody @Valid AttendanceCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive(message = "id must be positive") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}