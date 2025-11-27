package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeAttendanceService {

    AttendanceResponseDTO saveAttendance(AttendanceCreateDTO dto);

    List<AttendanceResponseDTO> getAttendanceByEmployee(Long employeeId);

    AttendanceResponseDTO getAttendanceById(Long id);

    List<AttendanceResponseDTO> getAttendanceByDate(LocalDate date);

    List<AttendanceResponseDTO> getAll();

    AttendanceResponseDTO updateAttendance(Long id, AttendanceCreateDTO dto);

    void deleteAttendance(Long id);
}