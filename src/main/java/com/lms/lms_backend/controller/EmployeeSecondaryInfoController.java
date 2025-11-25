package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/secondary")
public class EmployeeSecondaryInfoController {

    private final EmployeeSecondaryInfoService service;

    public EmployeeSecondaryInfoController(EmployeeSecondaryInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeSecondaryInfo> create(@RequestBody EmployeeSecondaryInfo info) {
        EmployeeSecondaryInfo saved = service.save(info);
        return ResponseEntity.created(URI.create("/api/employees/secondary/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeSecondaryInfo>> getByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployeeId(employeeId));
    }
}