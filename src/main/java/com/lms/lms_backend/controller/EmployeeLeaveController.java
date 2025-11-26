package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeeLeave;
import com.lms.lms_backend.service.EmployeeLeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/leaves")
public class EmployeeLeaveController {

    private final EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeLeave> createLeave(@RequestBody EmployeeLeave leave) {
        EmployeeLeave saved = service.saveLeave(leave);
        return ResponseEntity.created(
                URI.create("/api/employees/leaves/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeLeave>> getLeaves(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getLeavesByEmployee(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeave> getLeaveById(@PathVariable Long id) {
        return service.getLeaveById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}