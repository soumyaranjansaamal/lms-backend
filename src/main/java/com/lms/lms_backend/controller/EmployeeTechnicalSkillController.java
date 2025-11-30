package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;
import com.lms.lms_backend.service.EmployeeTechnicalSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/{employeeId}/skills")
@RequiredArgsConstructor
public class EmployeeTechnicalSkillController {

    private final EmployeeTechnicalSkillService service;

    @PostMapping
    public ResponseEntity<EmployeeTechnicalSkillDTO> createSkill(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody EmployeeTechnicalSkillDTO dto) {

        dto.setEmployeeId(employeeId);
        EmployeeTechnicalSkillDTO created = service.addSkill(dto);
        return ResponseEntity.created(URI.create("/api/employees/" + employeeId + "/skills/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeTechnicalSkillDTO>> listSkills(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getSkillsForEmployee(employeeId));
    }

    @DeleteMapping("/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long employeeId, @PathVariable Long skillId) {
        service.deleteSkill(skillId);
        return ResponseEntity.noContent().build();
    }
}