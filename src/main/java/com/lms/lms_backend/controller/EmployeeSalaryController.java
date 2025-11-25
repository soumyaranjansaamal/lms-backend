package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;
import com.lms.lms_backend.entity.EmployeeSalary;
import com.lms.lms_backend.service.EmployeeSalaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees/salary")
public class EmployeeSalaryController {

    private final EmployeeSalaryService service;

    public EmployeeSalaryController(EmployeeSalaryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeSalaryResponseDTO> createSalary(@RequestBody EmployeeSalaryCreateDTO dto) {

        EmployeeSalary salary = EmployeeSalary.builder()
                .employeeId(dto.getEmployeeId())
                .basic(dto.getBasic())
                .allowances(dto.getAllowances())
                .deductions(dto.getDeductions())
                .totalSalary(dto.getTotalSalary())
                .month(dto.getMonth())
                .year(dto.getYear())
                .build();

        EmployeeSalary saved = service.saveSalary(salary);

        EmployeeSalaryResponseDTO response = EmployeeSalaryResponseDTO.builder()
                .id(saved.getId())
                .employeeId(saved.getEmployeeId())
                .basic(saved.getBasic())
                .allowances(saved.getAllowances())
                .deductions(saved.getDeductions())
                .totalSalary(saved.getTotalSalary())
                .month(saved.getMonth())
                .year(saved.getYear())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-employee/{id}")
    public ResponseEntity<List<EmployeeSalaryResponseDTO>> getSalaryByEmployee(@PathVariable Long id) {

        List<EmployeeSalaryResponseDTO> list = service.getSalaryByEmployee(id)
                .stream()
                .map(s -> EmployeeSalaryResponseDTO.builder()
                        .id(s.getId())
                        .employeeId(s.getEmployeeId())
                        .basic(s.getBasic())
                        .allowances(s.getAllowances())
                        .deductions(s.getDeductions())
                        .totalSalary(s.getTotalSalary())
                        .month(s.getMonth())
                        .year(s.getYear())
                        .build()
                ).collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<Double> getTotalSalary(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTotalSalary(id));
    }
}