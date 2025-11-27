package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.entity.EmployeeAttendance;
import com.lms.lms_backend.mapper.EmployeeAttendanceMapper;
import com.lms.lms_backend.repository.EmployeeAttendanceRepository;
import com.lms.lms_backend.service.EmployeeAttendanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {

    private final EmployeeAttendanceRepository repository;

    public EmployeeAttendanceServiceImpl(EmployeeAttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttendanceResponseDTO saveAttendance(AttendanceCreateDTO dto) {
        EmployeeAttendance e = EmployeeAttendanceMapper.toEntity(dto);
        // optional: prevent duplicate record for same employee/date
        Optional<EmployeeAttendance> existing = repository.findByEmployeeIdAndDate(e.getEmployeeId(), e.getDate());
        if (existing.isPresent()) {
            EmployeeAttendance existingEntity = existing.get();
            EmployeeAttendanceMapper.updateEntityFromDto(dto, existingEntity);
            EmployeeAttendance saved = repository.save(existingEntity);
            return EmployeeAttendanceMapper.toDto(saved);
        } else {
            EmployeeAttendance saved = repository.save(e);
            return EmployeeAttendanceMapper.toDto(saved);
        }
    }

    @Override
    public List<AttendanceResponseDTO> getAttendanceByEmployee(Long employeeId) {
        return EmployeeAttendanceMapper.toDtoList(repository.findByEmployeeId(employeeId));
    }

    @Override
    public AttendanceResponseDTO getAttendanceById(Long id) {
        return repository.findById(id).map(EmployeeAttendanceMapper::toDto).orElse(null);
    }

    @Override
    public List<AttendanceResponseDTO> getAttendanceByDate(LocalDate date) {
        return EmployeeAttendanceMapper.toDtoList(repository.findByDate(date));
    }

    @Override
    public List<AttendanceResponseDTO> getAll() {
        return EmployeeAttendanceMapper.toDtoList(repository.findAll());
    }

    @Override
    public AttendanceResponseDTO updateAttendance(Long id, AttendanceCreateDTO dto) {
        Optional<EmployeeAttendance> opt = repository.findById(id);
        if (opt.isEmpty()) return null;
        EmployeeAttendance e = opt.get();
        EmployeeAttendanceMapper.updateEntityFromDto(dto, e);
        EmployeeAttendance saved = repository.save(e);
        return EmployeeAttendanceMapper.toDto(saved);
    }

    @Override
    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }
}