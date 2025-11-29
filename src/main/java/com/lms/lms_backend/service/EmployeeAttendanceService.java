package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeAttendanceService {

    AttendanceResponseDTO create(AttendanceCreateDTO dto);

    AttendanceResponseDTO getById(Long id);

    List<AttendanceResponseDTO> getByEmployeeId(Long employeeId);

    List<AttendanceResponseDTO> getByDate(LocalDate date);

    AttendanceResponseDTO update(Long id, AttendanceCreateDTO dto);

    void delete(Long id);
}