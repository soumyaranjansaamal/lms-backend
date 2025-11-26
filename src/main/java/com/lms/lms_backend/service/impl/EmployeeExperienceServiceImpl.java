package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeExperience;
import com.lms.lms_backend.repository.EmployeeExperienceRepository;
import com.lms.lms_backend.service.EmployeeExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeExperienceServiceImpl implements EmployeeExperienceService {

    private final EmployeeExperienceRepository repo;

    public EmployeeExperienceServiceImpl(EmployeeExperienceRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeExperience saveExperience(EmployeeExperience experience) {
        return repo.save(experience);
    }

    @Override
    public List<EmployeeExperience> getByEmployeeId(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public Optional<EmployeeExperience> getById(Long id) {
        return repo.findById(id);
    }
}