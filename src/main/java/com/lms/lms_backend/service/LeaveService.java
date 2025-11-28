package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface LeaveService {
    LeaveResponseDTO save(LeaveCreateDTO dto);
    LeaveResponseDTO getById(Long id);
    List<LeaveResponseDTO> getByEmployee(Long employeeId);
    List<LeaveResponseDTO> getByStartDate(LocalDate date);
    LeaveResponseDTO update(Long id, LeaveCreateDTO dto);
    void delete(Long id);
}