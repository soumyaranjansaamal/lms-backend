package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeePrimaryInfo;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.repository.EmployeePrimaryInfoRepository;
import com.lms.lms_backend.service.EmployeePrimaryInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePrimaryInfoServiceImpl implements EmployeePrimaryInfoService {

    private final EmployeePrimaryInfoRepository employeePrimaryInfoRepository;

    public EmployeePrimaryInfoServiceImpl(EmployeePrimaryInfoRepository employeePrimaryInfoRepository) {
        this.employeePrimaryInfoRepository = employeePrimaryInfoRepository;
    }

    @Override
    public EmployeePrimaryInfo saveEmployee(EmployeePrimaryInfo employee) {
        if (employee.getEmail() != null && employeePrimaryInfoRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return employeePrimaryInfoRepository.save(employee);
    }

    @Override
    public Optional<EmployeePrimaryInfo> getEmployeeById(Long id) {
        return employeePrimaryInfoRepository.findById(id);
    }

    @Override
    public Optional<EmployeePrimaryInfo> getEmployeeByEmail(String email) {
        return employeePrimaryInfoRepository.findByEmail(email);
    }

    @Override
    public EmployeePrimaryInfo updateEmployee(Long id, EmployeePrimaryInfo updated) {
        EmployeePrimaryInfo existing = employeePrimaryInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        // copy matching properties from updated -> existing (excluding id)
        BeanUtils.copyProperties(updated, existing, "id");

        // If you want to keep some fields untouched, add them to the excluded list above.
        return employeePrimaryInfoRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeePrimaryInfoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found");
        }
        employeePrimaryInfoRepository.deleteById(id);
    }

    @Override
    public List<EmployeePrimaryInfo> getAllEmployees() {
        return employeePrimaryInfoRepository.findAll();
    }

    // Implement the alias default methods from interface if needed (not required here)
}