package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeePrimaryInfoService employeePrimaryInfoService;

    public EmployeeController(EmployeePrimaryInfoService employeePrimaryInfoService) {
        this.employeePrimaryInfoService = employeePrimaryInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Optional<EmployeePrimaryInfo> opt = employeePrimaryInfoService.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", "Employee with id " + id + " not found"));
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeePrimaryInfo employee) {
        EmployeePrimaryInfo saved = employeePrimaryInfoService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeePrimaryInfo updated) {
        try {
            EmployeePrimaryInfo result = employeePrimaryInfoService.updateEmployee(id, updated);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", e.getMessage()));
        }
    }

    // add more endpoints as needed...
}