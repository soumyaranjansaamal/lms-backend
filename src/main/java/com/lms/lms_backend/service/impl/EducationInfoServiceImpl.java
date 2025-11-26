package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EducationInfo;
import com.lms.lms_backend.repository.EducationInfoRepository;
import com.lms.lms_backend.service.EducationInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationInfoServiceImpl implements EducationInfoService {

    private final EducationInfoRepository repository;

    public EducationInfoServiceImpl(EducationInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EducationInfo saveEducation(EducationInfo education) {
        return repository.save(education);
    }

    @Override
    public List<EducationInfo> getEducationByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}