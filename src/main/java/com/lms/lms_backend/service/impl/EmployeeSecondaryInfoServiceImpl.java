package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.repository.EmployeeSecondaryInfoRepository;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSecondaryInfoServiceImpl implements EmployeeSecondaryInfoService {

    private final EmployeeSecondaryInfoRepository repo;

    public EmployeeSecondaryInfoServiceImpl(EmployeeSecondaryInfoRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeSecondaryInfo save(EmployeeSecondaryInfo info) {
        return repo.save(info);
    }

    @Override
    public List<EmployeeSecondaryInfo> getByEmployeeId(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }
}