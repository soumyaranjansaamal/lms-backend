package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeExperience;
import com.lms.lms_backend.repository.EmployeeExperienceRepository;
import com.lms.lms_backend.service.EmployeeExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeExperienceServiceImpl implements EmployeeExperienceService {

    private final EmployeeExperienceRepository repository;

    public EmployeeExperienceServiceImpl(EmployeeExperienceRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeExperience saveExperience(EmployeeExperience experience) {
        return repository.save(experience);
    }

    @Override
    public List<EmployeeExperience> getByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeExperience getById(Long id) {
        Optional<EmployeeExperience> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void deleteExperience(Long id) {
        repository.deleteById(id);
    }
}