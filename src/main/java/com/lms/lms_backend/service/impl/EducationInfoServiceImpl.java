package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EducationInfo;
import com.lms.lms_backend.repository.EducationInfoRepository;
import com.lms.lms_backend.service.EducationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationInfoServiceImpl implements EducationInfoService {

    private final EducationInfoRepository repository;

    public EducationInfoServiceImpl(EducationInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EducationInfo save(EducationInfo info) {
        return repository.save(info);
    }

    @Override
    public List<EducationInfo> getByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public Optional<EducationInfo> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}