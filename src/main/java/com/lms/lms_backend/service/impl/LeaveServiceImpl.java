package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.entity.LeaveRequest;
import com.lms.lms_backend.mapper.LeaveMapper;
import com.lms.lms_backend.repository.LeaveRepository;
import com.lms.lms_backend.service.LeaveService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository repository;

    public LeaveServiceImpl(LeaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeaveResponseDTO save(LeaveCreateDTO dto) {
        LeaveRequest e = LeaveMapper.toEntity(dto);
        LeaveRequest saved = repository.save(e);
        return LeaveMapper.toDto(saved);
    }

    @Override
    public LeaveResponseDTO getById(Long id) {
        return repository.findById(id).map(LeaveMapper::toDto).orElse(null);
    }

    @Override
    public List<LeaveResponseDTO> getByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream().map(LeaveMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<LeaveResponseDTO> getByStartDate(LocalDate date) {
        return repository.findByStartDate(date).stream().map(LeaveMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LeaveResponseDTO update(Long id, LeaveCreateDTO dto) {
        return repository.findById(id).map(entity -> {
            LeaveMapper.updateEntity(entity, dto);
            LeaveRequest saved = repository.save(entity);
            return LeaveMapper.toDto(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}