package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.service.EmployeeLeaveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/leaves")
public class EmployeeLeaveController {

    private final EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeaveResponseDTO> apply(@Valid @RequestBody LeaveCreateDTO dto) {
        return ResponseEntity.status(201).body(service.applyLeave(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLeave(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveResponseDTO>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getLeavesByEmployee(employeeId));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveResponseDTO> approve(@PathVariable Long id) {
        return ResponseEntity.ok(service.approveLeave(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveResponseDTO> reject(@PathVariable Long id) {
        return ResponseEntity.ok(service.rejectLeave(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }
}