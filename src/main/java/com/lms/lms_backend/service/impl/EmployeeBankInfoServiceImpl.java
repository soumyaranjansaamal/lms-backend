package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeBankInfo;
import com.lms.lms_backend.repository.EmployeeBankInfoRepository;
import com.lms.lms_backend.service.EmployeeBankInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeBankInfoServiceImpl implements EmployeeBankInfoService {

    private final EmployeeBankInfoRepository repository;

    public EmployeeBankInfoServiceImpl(EmployeeBankInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeBankInfo saveBank(EmployeeBankInfo bankInfo) {
        return repository.save(bankInfo);
    }

    @Override
    public List<EmployeeBankInfo> getAllByEmployeeId(Long employeeId) {
        return repository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Optional<EmployeeBankInfo> getByEmployeeId(Long employeeId) {
        return repository.findFirstByEmployeeId(employeeId);
    }
}