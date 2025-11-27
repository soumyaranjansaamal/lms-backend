package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
// NOTE: changed base path to /api/attendance to avoid any accidental static-resource collisions
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {

    private final EmployeeAttendanceService service;

    public EmployeeAttendanceController(EmployeeAttendanceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AttendanceResponseDTO> create(@RequestBody AttendanceCreateDTO dto) {
        AttendanceResponseDTO saved = service.saveAttendance(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<AttendanceResponseDTO>> listByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getAttendanceByEmployee(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> getById(@PathVariable Long id) {
        AttendanceResponseDTO dto = service.getAttendanceById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(service.getAttendanceByDate(date));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AttendanceResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> update(@PathVariable Long id, @RequestBody AttendanceCreateDTO dto) {
        AttendanceResponseDTO updated = service.updateAttendance(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}