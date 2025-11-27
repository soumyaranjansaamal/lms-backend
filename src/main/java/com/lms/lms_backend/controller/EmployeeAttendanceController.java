package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {

    private final EmployeeAttendanceService service;

    public EmployeeAttendanceController(EmployeeAttendanceService service) {
        this.service = service;
    }

    // Create (or update if same employee+date exists — service handles that)
    @PostMapping
    public ResponseEntity<AttendanceResponseDTO> createAttendance(@RequestBody AttendanceCreateDTO dto) {
        AttendanceResponseDTO saved = service.saveAttendance(dto);
        return ResponseEntity.created(URI.create("/api/attendance/" + saved.getId())).body(saved);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> getById(@PathVariable Long id) {
        AttendanceResponseDTO dto = service.getAttendanceById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    // Get all attendance for an employee
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByEmployee(@PathVariable Long employeeId) {
        List<AttendanceResponseDTO> list = service.getAttendanceByEmployee(employeeId);
        return ResponseEntity.ok(list);
    }

    // Get attendance by date (ISO format: yyyy-MM-dd)
    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceResponseDTO>> getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<AttendanceResponseDTO> list = service.getAttendanceByDate(date);
        return ResponseEntity.ok(list);
    }

    // Get all records
    @GetMapping("/all")
    public ResponseEntity<List<AttendanceResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Update by id
    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponseDTO> updateAttendance(
            @PathVariable Long id,
            @RequestBody AttendanceCreateDTO dto) {

        AttendanceResponseDTO updated = service.updateAttendance(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        service.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}