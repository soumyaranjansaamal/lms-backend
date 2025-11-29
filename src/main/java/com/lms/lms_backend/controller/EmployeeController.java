package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeePrimaryInfoRepository repo;

    public EmployeeController(EmployeePrimaryInfoRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeePrimaryInfo e) {
        if (e.getEmail() != null && repo.existsByEmail(e.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        EmployeePrimaryInfo saved = repo.save(e);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return repo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(repo.findAll());
}

}