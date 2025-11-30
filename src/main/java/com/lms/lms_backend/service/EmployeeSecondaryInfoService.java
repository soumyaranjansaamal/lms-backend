package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeSecondaryInfoService {

    EmployeeSecondaryInfo create(EmployeeSecondaryInfoDTO dto);

    EmployeeSecondaryInfo update(Long id, EmployeeSecondaryInfoDTO dto);

    Optional<EmployeeSecondaryInfo> findById(Long id);

    Optional<EmployeeSecondaryInfo> findByEmployeeId(Long employeeId);

    List<EmployeeSecondaryInfo> findAll();

    void deleteById(Long id);
}