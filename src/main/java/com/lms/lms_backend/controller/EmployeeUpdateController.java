package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/update")
public class EmployeeUpdateController {

    private final EmployeePrimaryInfoService employeePrimaryInfoService;

    public EmployeeUpdateController(EmployeePrimaryInfoService employeePrimaryInfoService) {
        this.employeePrimaryInfoService = employeePrimaryInfoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EmployeePrimaryInfo payload) {
        try {
            EmployeePrimaryInfo updated = employeePrimaryInfoService.updateEmployee(id, payload);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", ex.getMessage()));
        }
    }
}