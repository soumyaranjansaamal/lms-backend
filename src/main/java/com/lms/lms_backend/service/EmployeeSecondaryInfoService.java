package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryInfoResponseDTO;

import java.util.List;

public interface EmployeeSecondaryInfoService {
    EmployeeSecondaryInfoResponseDTO create(EmployeeSecondaryInfoCreateDTO dto);
    List<EmployeeSecondaryInfoResponseDTO> getByEmployeeId(Long employeeId);
    EmployeeSecondaryInfoResponseDTO getById(Long id);
    EmployeeSecondaryInfoResponseDTO update(Long id, EmployeeSecondaryInfoCreateDTO dto);
    void delete(Long id);
}