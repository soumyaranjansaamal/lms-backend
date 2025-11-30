package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeePrimaryInfoService employeePrimaryInfoService;

    public EmployeeController(EmployeePrimaryInfoService employeePrimaryInfoService) {
        this.employeePrimaryInfoService = employeePrimaryInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        return employeePrimaryInfoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse("Not Found", "Employee with id " + id + " not found")));
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeePrimaryInfo employee) {
        EmployeePrimaryInfo saved = employeePrimaryInfoService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Add more endpoints as needed...
}