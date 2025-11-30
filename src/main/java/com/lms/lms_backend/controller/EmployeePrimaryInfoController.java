package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/primary-info")
public class EmployeePrimaryInfoController {

    private final EmployeePrimaryInfoService service;

    public EmployeePrimaryInfoController(EmployeePrimaryInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeePrimaryInfo employee) {
        EmployeePrimaryInfo saved = service.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<EmployeePrimaryInfo> opt = service.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", "Employee with id " + id + " not found"));
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<List<EmployeePrimaryInfo>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EmployeePrimaryInfo> opt = service.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", "Employee with id " + id + " not found"));
        }
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-email")
    public ResponseEntity<?> getByEmail(@RequestParam String email) {
        Optional<EmployeePrimaryInfo> opt = service.findByEmail(email);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", "Employee with email " + email + " not found"));
        }
        return ResponseEntity.ok(opt.get());
    }
}