package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;
import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.entity.EmployeeTechnicalSkill;
import com.lms.lms_backend.exception.NotFoundException;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.repository.EmployeeTechnicalSkillRepository;
import com.lms.lms_backend.service.EmployeeTechnicalSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeTechnicalSkillServiceImpl implements EmployeeTechnicalSkillService {

    private final EmployeeTechnicalSkillRepository repo;
    private final EmployeePrimaryInfoRepository employeeRepo;

    private EmployeeTechnicalSkillDTO toDto(EmployeeTechnicalSkill e) {
        return EmployeeTechnicalSkillDTO.builder()
                .id(e.getId())
                .employeeId(e.getEmployee() != null ? e.getEmployee().getId() : null)
                .skillName(e.getSkillName())
                .proficiency(e.getProficiency())
                .yearsExperience(e.getYearsExperience())
                .build();
    }

    @Override
    public EmployeeTechnicalSkillDTO addSkill(EmployeeTechnicalSkillDTO dto) {
        EmployeePrimaryInfo emp = employeeRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Employee not found: " + dto.getEmployeeId()));

        EmployeeTechnicalSkill ent = EmployeeTechnicalSkill.builder()
                .employee(emp)
                .skillName(dto.getSkillName())
                .proficiency(dto.getProficiency())
                .yearsExperience(dto.getYearsExperience())
                .build();

        ent = repo.save(ent);
        return toDto(ent);
    }

    @Override
    public List<EmployeeTechnicalSkillDTO> getSkillsForEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteSkill(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Skill not found: " + id);
        repo.deleteById(id);
    }
}