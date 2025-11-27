package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.entity.EmployeeAttendance;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAttendanceMapper {

    public static EmployeeAttendance toEntity(AttendanceCreateDTO dto) {
        if (dto == null) return null;
        EmployeeAttendance e = new EmployeeAttendance();
        e.setEmployeeId(dto.getEmployeeId());
        e.setDate(dto.getDate());
        e.setStatus(dto.getStatus());
        e.setInTime(dto.getInTime());
        e.setOutTime(dto.getOutTime());
        e.setRemarks(dto.getRemarks());
        return e;
    }

    public static AttendanceResponseDTO toDto(EmployeeAttendance e) {
        if (e == null) return null;
        AttendanceResponseDTO dto = new AttendanceResponseDTO();
        dto.setId(e.getId());
        dto.setEmployeeId(e.getEmployeeId());
        dto.setDate(e.getDate());
        dto.setStatus(e.getStatus());
        dto.setInTime(e.getInTime());
        dto.setOutTime(e.getOutTime());
        dto.setRemarks(e.getRemarks());
        return dto;
    }

    public static List<AttendanceResponseDTO> toDtoList(List<EmployeeAttendance> list) {
        return list.stream().map(EmployeeAttendanceMapper::toDto).collect(Collectors.toList());
    }

    public static void updateEntityFromDto(AttendanceCreateDTO dto, EmployeeAttendance e) {
        if (dto == null || e == null) return;
        if (dto.getEmployeeId() != null) e.setEmployeeId(dto.getEmployeeId());
        if (dto.getDate() != null) e.setDate(dto.getDate());
        if (dto.getStatus() != null) e.setStatus(dto.getStatus());
        if (dto.getInTime() != null) e.setInTime(dto.getInTime());
        if (dto.getOutTime() != null) e.setOutTime(dto.getOutTime());
        if (dto.getRemarks() != null) e.setRemarks(dto.getRemarks());
    }
}