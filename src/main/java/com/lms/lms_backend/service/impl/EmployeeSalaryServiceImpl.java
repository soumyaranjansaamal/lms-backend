package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeSalary;
import com.lms.lms_backend.repository.EmployeeSalaryRepository;
import com.lms.lms_backend.service.EmployeeSalaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

    private final EmployeeSalaryRepository repo;

    public EmployeeSalaryServiceImpl(EmployeeSalaryRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeSalary saveSalary(EmployeeSalary salary) {
        return repo.save(salary);
    }

    @Override
    public List<EmployeeSalary> getSalaryByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public double getTotalSalary(Long employeeId) {
        return repo.findByEmployeeId(employeeId)
                .stream()
                .mapToDouble(EmployeeSalary::getTotalSalary)
                .sum();
    }
}