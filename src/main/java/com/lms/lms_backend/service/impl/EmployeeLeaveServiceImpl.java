package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.entity.LeaveRequest;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.mapper.EmployeeLeaveMapper;
import com.lms.lms_backend.repository.LeaveRepository;
import com.lms.lms_backend.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final LeaveRepository repository;

    public EmployeeLeaveServiceImpl(LeaveRepository repository) {
        this.repository = repository;
    }

    /**
     * Apply a new leave (create).
     */
    @Override
    public LeaveResponseDTO applyLeave(LeaveCreateDTO dto) {
        LeaveRequest entity = EmployeeLeaveMapper.toEntity(dto);

        // default status if mapper didn't set it
        if (entity.getStatus() == null) {
            entity.setStatus("PENDING");
        }

        LeaveRequest saved = repository.save(entity);
        return EmployeeLeaveMapper.toDto(saved);
    }

    /**
     * Get single leave by id.
     */
    @Override
    public LeaveResponseDTO getLeave(Long id) {
        LeaveRequest e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave not found with id: " + id));
        return EmployeeLeaveMapper.toDto(e);
    }

    /**
     * Get leaves by employee id.
     */
    @Override
    public List<LeaveResponseDTO> getLeavesByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId)
                .stream()
                .map(EmployeeLeaveMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Approve a leave and return the updated DTO.
     */
    @Override
    public LeaveResponseDTO approveLeave(Long id) {
        LeaveRequest entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave not found with id: " + id));
        entity.setStatus("APPROVED");
        LeaveRequest saved = repository.save(entity);
        return EmployeeLeaveMapper.toDto(saved);
    }

    /**
     * Reject a leave and return the updated DTO.
     */
    @Override
    public LeaveResponseDTO rejectLeave(Long id) {
        LeaveRequest entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave not found with id: " + id));
        entity.setStatus("REJECTED");
        LeaveRequest saved = repository.save(entity);
        return EmployeeLeaveMapper.toDto(saved);
    }

    /**
     * Delete leave by id.
     */
    @Override
    public void deleteLeave(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Leave not found with id: " + id);
        }
        repository.deleteById(id);
    }
}