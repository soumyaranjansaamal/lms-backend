package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/primary")
public class EmployeePrimaryInfoController {

    private final EmployeePrimaryInfoService service;

    public EmployeePrimaryInfoController(EmployeePrimaryInfoService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeePrimaryInfo employee) {
        try {
            return ResponseEntity.ok(service.saveEmployee(employee));
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Validation Failed", ex.getMessage(), 400));
        }
    }

    // GET BY ID (FIXED — No Optional.map lambda)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var result = service.getEmployeeById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(404)
                .body(new ErrorResponse("Not Found", "Employee not found", 404));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // GET BY EMAIL (FIXED)
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        var result = service.getEmployeeByEmail(email);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(404)
                .body(new ErrorResponse("Not Found", "Employee not found", 404));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePrimaryInfo updated
    ) {
        try {
            return ResponseEntity.ok(service.updateEmployee(id, updated));
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Update Failed", ex.getMessage(), 400));
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            service.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(404)
                    .body(new ErrorResponse("Delete Failed", ex.getMessage(), 404));
        }
    }
}