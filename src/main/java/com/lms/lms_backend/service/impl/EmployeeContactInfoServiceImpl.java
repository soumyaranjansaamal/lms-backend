package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeContactInfoDTO;
import com.lms.lms_backend.entity.EmployeeContactInfo;
import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.NotFoundException;
import com.lms.lms_backend.repository.EmployeeContactInfoRepository;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.service.EmployeeContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeContactInfoServiceImpl implements EmployeeContactInfoService {

    private final EmployeeContactInfoRepository repo;
    private final EmployeePrimaryInfoRepository employeeRepo;

    private EmployeeContactInfoDTO toDto(EmployeeContactInfo e) {
        return EmployeeContactInfoDTO.builder()
                .id(e.getId())
                .employeeId(e.getEmployee() != null ? e.getEmployee().getId() : null)
                .contactType(e.getContactType())
                .contactValue(e.getContactValue())
                .primaryContact(e.getPrimaryContact())
                .build();
    }

    @Override
    public EmployeeContactInfoDTO addContact(EmployeeContactInfoDTO dto) {
        EmployeePrimaryInfo emp = employeeRepo.findById(dto.getEmployeeId()).orElseThrow(() -> new NotFoundException("Employee not found"));
        EmployeeContactInfo ent = EmployeeContactInfo.builder()
                .employee(emp)
                .contactType(dto.getContactType())
                .contactValue(dto.getContactValue())
                .primaryContact(dto.getPrimaryContact())
                .build();
        ent = repo.save(ent);
        return toDto(ent);
    }

    @Override
    public List<EmployeeContactInfoDTO> getContactsForEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId).stream().map(this::toDto).collect(Collectors.toList());
    }
}