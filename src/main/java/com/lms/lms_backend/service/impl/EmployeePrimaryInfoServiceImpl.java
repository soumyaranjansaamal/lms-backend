package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.NotFoundException;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Simple, clear implementation for EmployeePrimaryInfoService.
 * Replace/extend this if your interface has additional methods.
 */
@Service
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
        Optional<EmployeePrimaryInfo> o = repository.findById(id);
        return o.orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
    }

    @Override
    public List<EmployeePrimaryInfo> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated) {
        EmployeePrimaryInfo existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found with id: " + id));
        // copy allowed fields (adjust as per your entity fields)
        existing.setEmployeeName(updated.getEmployeeName());
        existing.setGender(updated.getGender());
        existing.setDateOfBirth(updated.getDateOfBirth());
        existing.setQualification(updated.getQualification());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        // ... any other fields you have
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }
}