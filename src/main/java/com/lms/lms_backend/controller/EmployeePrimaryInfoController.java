package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ErrorResponse;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            EmployeePrimaryInfo saved = service.saveEmployee(employee);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Validation Failed", ex.getMessage(), 400));
        }
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(new ErrorResponse("Not Found", "Employee not found", 404)));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<EmployeePrimaryInfo>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // GET BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        return service.getEmployeeByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(new ErrorResponse("Not Found", "Employee not found", 404)));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePrimaryInfo updated
    ) {
        try {
            EmployeePrimaryInfo saved = service.updateEmployee(id, updated);
            return ResponseEntity.ok(saved);
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