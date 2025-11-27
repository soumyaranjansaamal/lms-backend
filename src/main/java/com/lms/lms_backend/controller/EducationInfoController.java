package com.lms.lms_backend.controller;

import com.lms.lms_backend.entity.EducationInfo;
import com.lms.lms_backend.service.EducationInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/education")
public class EducationInfoController {

    private final EducationInfoService service;

    public EducationInfoController(EducationInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EducationInfo> create(@RequestBody EducationInfo info) {
        EducationInfo saved = service.save(info);
        return ResponseEntity.created(URI.create("/api/employees/education/" + saved.getId())).body(saved);
    }

    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EducationInfo>> listByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployeeId(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationInfo> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}