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

    private final EmployeeLeaveService leaveService;

    public EmployeeLeaveController(EmployeeLeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping
    public ResponseEntity<EmployeeLeave> createLeave(@RequestBody EmployeeLeave leave) {
        EmployeeLeave saved = leaveService.saveLeave(leave);
        return ResponseEntity.created(URI.create("/api/employees/leaves/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeLeave>> getLeaves(@PathVariable Long employeeId) {
        return ResponseEntity.ok(leaveService.getLeavesByEmployee(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLeave> getLeaveById(@PathVariable Long id) {
        EmployeeLeave leave = leaveService.getLeaveById(id)
                .orElse(null);

        if (leave == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leave);
    }
}