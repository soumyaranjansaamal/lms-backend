package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeTechnicalSkillDTO;
import com.lms.lms_backend.entity.EmployeeTechnicalSkill;
import com.lms.lms_backend.repository.EmployeeTechnicalSkillRepository;
import com.lms.lms_backend.service.EmployeeTechnicalSkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeTechnicalSkillServiceImpl implements EmployeeTechnicalSkillService {

    private final EmployeeTechnicalSkillRepository repository;

    public EmployeeTechnicalSkillServiceImpl(EmployeeTechnicalSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeTechnicalSkill create(EmployeeTechnicalSkillDTO dto) {
        EmployeeTechnicalSkill ent = new EmployeeTechnicalSkill();
        ent.setEmployeeId(dto.getEmployeeId());
        ent.setSkillName(dto.getSkillName());
        ent.setProficiency(dto.getProficiency());
        ent.setYearsExperience(dto.getYearsExperience());
        return repository.save(ent);
    }

    @Override
    public Optional<EmployeeTechnicalSkill> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EmployeeTechnicalSkill> findAllByEmployeeId(Long employeeId) {
        return repository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeTechnicalSkill update(Long id, EmployeeTechnicalSkillDTO dto) {
        EmployeeTechnicalSkill updated = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Technical skill not found with id: " + id));
        // update fields if provided
        if (dto.getSkillName() != null) updated.setSkillName(dto.getSkillName());
        if (dto.getProficiency() != null) updated.setProficiency(dto.getProficiency());
        if (dto.getYearsExperience() != null) updated.setYearsExperience(dto.getYearsExperience());
        if (dto.getEmployeeId() != null) updated.setEmployeeId(dto.getEmployeeId());
        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Technical skill not found with id: " + id);
        }
    }
}