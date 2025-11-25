package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeLeaveCreateDTO;
import com.lms.lms_backend.dto.EmployeeLeaveResponseDTO;
import com.lms.lms_backend.entity.EmployeeLeave;
import com.lms.lms_backend.service.EmployeeLeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees/leaves")
public class EmployeeLeaveController {

    private final EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeLeaveResponseDTO> createLeave(@RequestBody EmployeeLeaveCreateDTO dto) {
        EmployeeLeave leave = EmployeeLeave.builder()
                .employeeId(dto.getEmployeeId())
                .leaveType(dto.getLeaveType())
                .days(dto.getDays())
                .reason(dto.getReason())
                .build();

        EmployeeLeave saved = service.saveLeave(leave);

        EmployeeLeaveResponseDTO resp = EmployeeLeaveResponseDTO.builder()
                .id(saved.getId())
                .employeeId(saved.getEmployeeId())
                .leaveType(saved.getLeaveType())
                .days(saved.getDays())
                .reason(saved.getReason())
                .status(saved.getStatus())
                .build();

        return ResponseEntity.created(URI.create("/api/employees/leaves/" + saved.getId()))
                .body(resp);
    }

    @GetMapping("/by-employee/{id}")
    public ResponseEntity<List<EmployeeLeaveResponseDTO>> getByEmployee(@PathVariable Long id) {
        List<EmployeeLeaveResponseDTO> list = service.getLeavesByEmployee(id)
                .stream()
                .map(l -> EmployeeLeaveResponseDTO.builder()
                        .id(l.getId())
                        .employeeId(l.getEmployeeId())
                        .leaveType(l.getLeaveType())
                        .days(l.getDays())
                        .reason(l.getReason())
                        .status(l.getStatus())
                        .build()
                ).collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<EmployeeLeaveResponseDTO> approve(@PathVariable Long id) {
        EmployeeLeave updated = service.approveLeave(id);
        if (updated == null) return ResponseEntity.notFound().build();
        EmployeeLeaveResponseDTO resp = EmployeeLeaveResponseDTO.builder()
                .id(updated.getId())
                .employeeId(updated.getEmployeeId())
                .leaveType(updated.getLeaveType())
                .days(updated.getDays())
                .reason(updated.getReason())
                .status(updated.getStatus())
                .build();
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/reject/{id}")
    public ResponseEntity<EmployeeLeaveResponseDTO> reject(@PathVariable Long id) {
        EmployeeLeave updated = service.rejectLeave(id);
        if (updated == null) return ResponseEntity.notFound().build();
        EmployeeLeaveResponseDTO resp = EmployeeLeaveResponseDTO.builder()
                .id(updated.getId())
                .employeeId(updated.getEmployeeId())
                .leaveType(updated.getLeaveType())
                .days(updated.getDays())
                .reason(updated.getReason())
                .status(updated.getStatus())
                .build();
        return ResponseEntity.ok(resp);
    }
}