package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeContactInfoDTO;
import com.lms.lms_backend.service.EmployeeContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees/{employeeId}/contacts")
@RequiredArgsConstructor
public class EmployeeContactInfoController {

    private final EmployeeContactInfoService service;

    @PostMapping
    public ResponseEntity<EmployeeContactInfoDTO> addContact(@PathVariable Long employeeId, @RequestBody EmployeeContactInfoDTO dto) {
        dto.setEmployeeId(employeeId);
        EmployeeContactInfoDTO created = service.addContact(dto);
        return ResponseEntity.created(URI.create("/api/employees/" + employeeId + "/contacts/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeContactInfoDTO>> listContacts(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getContactsForEmployee(employeeId));
    }
}