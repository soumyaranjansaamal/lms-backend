package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.entity.EmployeeAttendance;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.mapper.EmployeeAttendanceMapper;
import com.lms.lms_backend.repository.EmployeeAttendanceRepository;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {

    private final EmployeeAttendanceRepository repository;

    public EmployeeAttendanceServiceImpl(EmployeeAttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttendanceResponseDTO create(AttendanceCreateDTO dto) {
        EmployeeAttendance entity = EmployeeAttendanceMapper.toEntity(dto);
        EmployeeAttendance saved = repository.save(entity);
        return EmployeeAttendanceMapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public AttendanceResponseDTO getById(Long id) {
        EmployeeAttendance e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
        return EmployeeAttendanceMapper.toDto(e);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceResponseDTO> getByEmployeeId(Long employeeId) {
        List<EmployeeAttendance> list = repository.findByEmployeeId(employeeId);
        return list.stream().map(EmployeeAttendanceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceResponseDTO> getByDate(LocalDate date) {
        List<EmployeeAttendance> list = repository.findByDate(date);
        return list.stream().map(EmployeeAttendanceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AttendanceResponseDTO update(Long id, AttendanceCreateDTO dto) {
        EmployeeAttendance existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
        EmployeeAttendanceMapper.updateEntity(existing, dto);
        EmployeeAttendance updated = repository.save(existing);
        return EmployeeAttendanceMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance not found with id: " + id);
        }
        repository.deleteById(id);
    }
}