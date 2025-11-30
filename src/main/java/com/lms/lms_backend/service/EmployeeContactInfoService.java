package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeContactInfoDTO;

import java.util.List;

public interface EmployeeContactInfoService {
    EmployeeContactInfoDTO addContact(EmployeeContactInfoDTO dto);
    List<EmployeeContactInfoDTO> getContactsForEmployee(Long employeeId);
}