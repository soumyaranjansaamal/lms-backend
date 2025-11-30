package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;
import com.lms.lms_backend.entity.EmployeeTechnicalSkill;
import com.lms.lms_backend.service.EmployeeTechnicalSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technical-skills")
public class EmployeeTechnicalSkillController {

    private final EmployeeTechnicalSkillService service;

    public EmployeeTechnicalSkillController(EmployeeTechnicalSkillService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeTechnicalSkillDTO dto) {
        try {
            EmployeeTechnicalSkill created = service.create(dto);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to create technical skill: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found"));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeTechnicalSkill>> getByEmployee(@PathVariable Long employeeId) {
        List<EmployeeTechnicalSkill> list = service.findAllByEmployeeId(employeeId);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EmployeeTechnicalSkillDTO dto) {
        try {
            EmployeeTechnicalSkill updated = service.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}