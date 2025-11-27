package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;
import com.lms.lms_backend.entity.EmployeeSalary;
import com.lms.lms_backend.mapper.EmployeeSalaryMapper;
import com.lms.lms_backend.repository.EmployeeSalaryRepository;
import com.lms.lms_backend.service.EmployeeSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

    private final EmployeeSalaryRepository repository;

    public EmployeeSalaryServiceImpl(EmployeeSalaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSalaryResponseDTO saveSalary(EmployeeSalaryCreateDTO dto) {
        EmployeeSalary e = EmployeeSalaryMapper.toEntity(dto);
        EmployeeSalary saved = repository.save(e);
        return EmployeeSalaryMapper.toDto(saved);
    }

    @Override
    public List<EmployeeSalaryResponseDTO> getSalaryByEmployee(Long employeeId) {
        List<EmployeeSalary> list = repository.findByEmployeeId(employeeId);
        return EmployeeSalaryMapper.toDtoList(list);
    }

    @Override
    public EmployeeSalaryResponseDTO getSalaryById(Long id) {
        return repository.findById(id)
                .map(EmployeeSalaryMapper::toDto)
                .orElse(null);
    }

    @Override
    public BigDecimal getTotalSalary(Long employeeId) {
        List<EmployeeSalary> list = repository.findByEmployeeId(employeeId);
        return list.stream()
                .map(EmployeeSalary::getTotalSalary)
                .filter(v -> v != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void deleteSalary(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
    }
}