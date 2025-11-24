package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeCreateDTO;
import com.lms.lms_backend.dto.EmployeeResponseDTO;
import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeePrimaryInfoController {

    private final EmployeePrimaryInfoService service;

    public EmployeePrimaryInfoController(EmployeePrimaryInfoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @Valid @RequestBody EmployeeCreateDTO dto) {

        EmployeePrimaryInfo employee = EmployeePrimaryInfo.builder()
                .employeeName(dto.getEmployeeName())
                .gender(dto.getGender())
                .dateOfBirth(dto.getDateOfBirth())
                .qualification(dto.getQualification())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        EmployeePrimaryInfo saved = service.saveEmployee(employee);

        EmployeeResponseDTO response = EmployeeResponseDTO.builder()
                .id(saved.getId())
                .employeeName(saved.getEmployeeName())
                .gender(saved.getGender())
                .dateOfBirth(saved.getDateOfBirth())
                .qualification(saved.getQualification())
                .email(saved.getEmail())
                .phoneNumber(saved.getPhoneNumber())
                .build();

        return ResponseEntity
                .created(URI.create("/api/employees/" + saved.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable Long id) {
        EmployeePrimaryInfo employee = service.getEmployeeById(id);

        EmployeeResponseDTO response = EmployeeResponseDTO.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .gender(employee.getGender())
                .dateOfBirth(employee.getDateOfBirth())
                .qualification(employee.getQualification())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> list = service.getAllEmployees().stream()
                .map(emp -> EmployeeResponseDTO.builder()
                        .id(emp.getId())
                        .employeeName(emp.getEmployeeName())
                        .gender(emp.getGender())
                        .dateOfBirth(emp.getDateOfBirth())
                        .qualification(emp.getQualification())
                        .email(emp.getEmail())
                        .phoneNumber(emp.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    // -----------------------------
    // UPDATE employee (PUT)
    // -----------------------------
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeCreateDTO dto) {

        EmployeePrimaryInfo updated = EmployeePrimaryInfo.builder()
                .employeeName(dto.getEmployeeName())
                .gender(dto.getGender())
                .dateOfBirth(dto.getDateOfBirth())
                .qualification(dto.getQualification())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        EmployeePrimaryInfo saved = service.updateEmployee(id, updated);

        EmployeeResponseDTO response = EmployeeResponseDTO.builder()
                .id(saved.getId())
                .employeeName(saved.getEmployeeName())
                .gender(saved.getGender())
                .dateOfBirth(saved.getDateOfBirth())
                .qualification(saved.getQualification())
                .email(saved.getEmail())
                .phoneNumber(saved.getPhoneNumber())
                .build();

        return ResponseEntity.ok(response);
    }

    // -----------------------------
    // DELETE employee (DELETE)
    // -----------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}