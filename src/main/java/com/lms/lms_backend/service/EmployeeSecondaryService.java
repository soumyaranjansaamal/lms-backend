package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeSecondaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryResponseDTO;

import java.util.List;

public interface EmployeeSecondaryService {

    EmployeeSecondaryResponseDTO create(EmployeeSecondaryCreateDTO dto);

    EmployeeSecondaryResponseDTO getById(Long id);

    List<EmployeeSecondaryResponseDTO> getByEmployeeId(Long employeeId);

    EmployeeSecondaryResponseDTO update(Long id, EmployeeSecondaryCreateDTO dto);

    void delete(Long id);
}