package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.entity.LeaveRequest;
import com.lms.lms_backend.mapper.EmployeeLeaveMapper;
import com.lms.lms_backend.repository.EmployeeLeaveRepository;
import com.lms.lms_backend.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final EmployeeLeaveRepository repository;

    public EmployeeLeaveServiceImpl(EmployeeLeaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeaveResponseDTO create(LeaveCreateDTO dto) {
        LeaveRequest entity = EmployeeLeaveMapper.toEntity(dto);
        LeaveRequest saved = repository.save(entity);
        return EmployeeLeaveMapper.toDto(saved);
    }

    @Override
    public LeaveResponseDTO getById(Long id) {
        LeaveRequest e = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave record not found"));
        return EmployeeLeaveMapper.toDto(e);
    }

    @Override
    public List<LeaveResponseDTO> getByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId)
                .stream()
                .map(EmployeeLeaveMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(EmployeeLeaveMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveResponseDTO update(Long id, LeaveCreateDTO dto) {
        LeaveRequest entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave record not found"));

        EmployeeLeaveMapper.updateEntity(entity, dto);

        LeaveRequest updated = repository.save(entity);
        return EmployeeLeaveMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}