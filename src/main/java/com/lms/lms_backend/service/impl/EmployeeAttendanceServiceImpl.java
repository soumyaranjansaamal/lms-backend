package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.entity.EmployeeAttendance;
import com.lms.lms_backend.mapper.EmployeeAttendanceMapper;
import com.lms.lms_backend.repository.EmployeeAttendanceRepository;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {

    private final EmployeeAttendanceRepository repo;

    public EmployeeAttendanceServiceImpl(EmployeeAttendanceRepository repo) {
        this.repo = repo;
    }

    @Override
    public AttendanceResponseDTO save(AttendanceCreateDTO dto) {
        EmployeeAttendance entity = EmployeeAttendanceMapper.toEntity(dto);
        EmployeeAttendance saved = repo.save(entity);
        return EmployeeAttendanceMapper.toDto(saved);
    }

    @Override
    public AttendanceResponseDTO getById(Long id) {
        return repo.findById(id).map(EmployeeAttendanceMapper::toDto).orElse(null);
    }

    @Override
    public List<AttendanceResponseDTO> getByEmployeeId(Long employeeId) {
        return repo.findByEmployeeId(employeeId).stream()
                .map(EmployeeAttendanceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AttendanceResponseDTO> getByDate(LocalDate date) {
        return repo.findByDate(date).stream()
                .map(EmployeeAttendanceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceResponseDTO update(Long id, AttendanceCreateDTO dto) {
        return repo.findById(id).map(existing -> {
            // update existing entity with DTO (mapper helper)
            EmployeeAttendance updated = EmployeeAttendanceMapper.updateEntity(existing, dto);
            EmployeeAttendance saved = repo.save(updated);
            return EmployeeAttendanceMapper.toDto(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}