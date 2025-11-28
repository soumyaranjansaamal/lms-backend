package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
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

    /**
     * Create/save employee.
     * The project previously used saveEmployee(...) in the service layer,
     * so we delegate to that method so the controller matches existing service impl.
     */
    @PostMapping
    public ResponseEntity<EmployeePrimaryInfo> create(@RequestBody EmployeePrimaryInfo employee) {
        EmployeePrimaryInfo saved = service.saveEmployee(employee);
        return ResponseEntity.status(201).body(saved);
    }

    /**
     * Get by id.
     * Delegates to existing getEmployeeById(...) which your codebase used earlier.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeePrimaryInfo> getById(@PathVariable Long id) {
        EmployeePrimaryInfo emp = service.getEmployeeById(id);
        return emp == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(emp);
    }

    /**
     * Get all employees.
     * Delegates to existing getAllEmployees() method (which returns List<EmployeePrimaryInfo>).
     */
    @GetMapping
    public ResponseEntity<List<EmployeePrimaryInfo>> getAll() {
        List<EmployeePrimaryInfo> list = service.getAllEmployees();
        return ResponseEntity.ok(list);
    }

    /**
     * Update employee by id.
     * Delegates to updateEmployee(id, updated) used by the service impl before.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeePrimaryInfo> update(@PathVariable Long id,
                                                      @RequestBody EmployeePrimaryInfo updated) {
        EmployeePrimaryInfo saved = service.updateEmployee(id, updated);
        return saved == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(saved);
    }

    /**
     * Delete employee.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}