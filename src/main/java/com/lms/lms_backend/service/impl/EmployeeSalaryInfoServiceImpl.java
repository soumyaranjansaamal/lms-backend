package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeSalaryInfo;
import com.lms.lms_backend.repository.EmployeeSalaryInfoRepository;
import com.lms.lms_backend.service.EmployeeSalaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryInfoServiceImpl implements EmployeeSalaryInfoService {

    private final EmployeeSalaryInfoRepository repository;

    public EmployeeSalaryInfoServiceImpl(EmployeeSalaryInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSalaryInfo saveSalary(EmployeeSalaryInfo salaryInfo) {
        return repository.save(salaryInfo);
    }

    @Override
    public List<EmployeeSalaryInfo> getAllSalaryByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public Double getTotalSalaryByEmployee(Long employeeId) {
        List<EmployeeSalaryInfo> list = repository.findByEmployeeId(employeeId);
        return list.stream()
                .mapToDouble(EmployeeSalaryInfo::getTotalSalary)
                .sum();
    }
}