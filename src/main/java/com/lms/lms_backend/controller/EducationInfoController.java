package com.lms.lms_backend.controller;

import com.lms.lms_backend.dto.EducationCreateDTO;
import com.lms.lms_backend.dto.EducationResponseDTO;
import com.lms.lms_backend.entity.EducationInfo;
import com.lms.lms_backend.service.EducationInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees/education")
public class EducationInfoController {

    private final EducationInfoService service;

    public EducationInfoController(EducationInfoService service) {
        this.service = service;
    }

    // CREATE education
    @PostMapping
    public ResponseEntity<EducationResponseDTO> createEducation(@RequestBody EducationCreateDTO dto) {
        EducationInfo info = EducationInfo.builder()
                .employeeId(dto.getEmployeeId())
                .degree(dto.getDegree())
                .college(dto.getCollege())
                .yearOfPassing(dto.getYearOfPassing())
                .grade(dto.getGrade())
                .build();

        EducationInfo saved = service.saveEducation(info);

        EducationResponseDTO res = EducationResponseDTO.builder()
                .id(saved.getId())
                .employeeId(saved.getEmployeeId())
                .degree(saved.getDegree())
                .college(saved.getCollege())
                .yearOfPassing(saved.getYearOfPassing())
                .grade(saved.getGrade())
                .build();

        return ResponseEntity.created(URI.create("/api/employees/education/" + saved.getId()))
                .body(res);
    }

    // GET all education by employee ID
    @GetMapping("/by-employee/{employeeId}")
    public ResponseEntity<List<EducationResponseDTO>> getEducation(@PathVariable Long employeeId) {
        List<EducationResponseDTO> list = service.getEducationByEmployeeId(employeeId)
                .stream()
                .map(info -> EducationResponseDTO.builder()
                        .id(info.getId())
                        .employeeId(info.getEmployeeId())
                        .degree(info.getDegree())
                        .college(info.getCollege())
                        .yearOfPassing(info.getYearOfPassing())
                        .grade(info.getGrade())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }
}