package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeePrimaryInfoServiceImpl implements EmployeePrimaryInfoService {

    private final EmployeePrimaryInfoRepository repository;

    public EmployeePrimaryInfoServiceImpl(EmployeePrimaryInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeePrimaryInfo saveEmployee(EmployeePrimaryInfo employee) {
        return repository.save(employee);
    }

    @Override
    public EmployeePrimaryInfo getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeePrimaryInfo> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated) {
        Optional<EmployeePrimaryInfo> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return null; // or throw NotFoundException if you prefer
        }
        EmployeePrimaryInfo existing = opt.get();

        // copy fields - adjust to your entity fields
        existing.setEmployeeName(updated.getEmployeeName());
        existing.setDateOfBirth(updated.getDateOfBirth());
        existing.setEmail(updated.getEmail());
        existing.setGender(updated.getGender());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setQualification(updated.getQualification());
        // add other fields as needed

        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}