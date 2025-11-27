package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EmployeeExperience;
import com.lms.lms_backend.service.EmployeeExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/experience")
public class EmployeeExperienceController {

    private final EmployeeExperienceService service;

    public EmployeeExperienceController(EmployeeExperienceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeExperience> createExperience(@RequestBody EmployeeExperience experience) {
        EmployeeExperience saved = service.saveExperience(experience);
        return ResponseEntity.created(URI.create("/api/employees/experience/" + saved.getId())).body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EmployeeExperience>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployeeId(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeExperience> getById(@PathVariable Long id) {
        EmployeeExperience exp = service.getById(id);
        if (exp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(exp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteExperience(id);
        return ResponseEntity.noContent().build();
    }
}