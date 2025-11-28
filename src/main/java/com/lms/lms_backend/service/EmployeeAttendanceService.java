package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeAttendanceService {
    AttendanceResponseDTO save(AttendanceCreateDTO dto);              // used by controller POST
    AttendanceResponseDTO getById(Long id);                          // used by controller GET /{id}
    List<AttendanceResponseDTO> getByEmployeeId(Long employeeId);    // used by controller GET /by-employee/{employeeId}
    List<AttendanceResponseDTO> getByDate(LocalDate date);           // used by controller GET /by-date/{date}
    AttendanceResponseDTO update(Long id, AttendanceCreateDTO dto);  // used by controller PUT
    void delete(Long id);                                            // used by controller DELETE
}