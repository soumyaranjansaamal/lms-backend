package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<EmployeePrimaryInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EmployeePrimaryInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<EmployeePrimaryInfo> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated) {
        // basic approach: fetch, copy mutable fields, save
        Optional<EmployeePrimaryInfo> existingOpt = repository.findById(id);
        if (existingOpt.isEmpty()) {
            throw new IllegalArgumentException("Employee not found with id: " + id);
        }
        EmployeePrimaryInfo existing = existingOpt.get();

        // copy fields you want to allow updating (example fields; adapt to your entity)
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        // add more fields as appropriate for your EmployeePrimaryInfo

        return repository.save(existing);
    }
}