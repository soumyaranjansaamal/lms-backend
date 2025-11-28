package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.AttendanceCreateDTO;
import com.lms.lms_backend.dto.AttendanceResponseDTO;
import com.lms.lms_backend.entity.EmployeeAttendance;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Mapper for EmployeeAttendance <-> DTOs
 */
public class EmployeeAttendanceMapper {

    // Convert DTO -> Entity (create)
    public static EmployeeAttendance toEntity(AttendanceCreateDTO dto) {
        if (dto == null) return null;

        EmployeeAttendance e = new EmployeeAttendance();
        e.setEmployeeId(dto.getEmployeeId());
        e.setStatus(dto.getStatus());
        e.setRemarks(dto.getRemarks());

        // convert date string -> LocalDate
        if (dto.getDate() != null && !dto.getDate().isBlank()) {
            e.setDate(LocalDate.parse(dto.getDate()));
        } else {
            e.setDate(null);
        }

        // convert times -> LocalTime
        if (dto.getInTime() != null && !dto.getInTime().isBlank()) {
            e.setInTime(LocalTime.parse(dto.getInTime()));
        } else {
            e.setInTime(null);
        }

        if (dto.getOutTime() != null && !dto.getOutTime().isBlank()) {
            e.setOutTime(LocalTime.parse(dto.getOutTime()));
        } else {
            e.setOutTime(null);
        }

        return e;
    }

    // Convert Entity -> DTO
    public static AttendanceResponseDTO toDto(EmployeeAttendance a) {
        if (a == null) return null;

        AttendanceResponseDTO dto = new AttendanceResponseDTO();
        dto.setId(a.getId());
        dto.setEmployeeId(a.getEmployeeId());
        dto.setStatus(a.getStatus());
        dto.setRemarks(a.getRemarks());

        // assign LocalDate / LocalTime directly (DTO expects these types)
        dto.setDate(a.getDate());         // LocalDate or null
        dto.setInTime(a.getInTime());     // LocalTime or null
        dto.setOutTime(a.getOutTime());   // LocalTime or null

        return dto;
    }

    // Update an existing entity using DTO fields (for PUT/patch-like updates)
    public static EmployeeAttendance updateEntity(EmployeeAttendance entity, AttendanceCreateDTO dto) {
        if (entity == null || dto == null) return entity;

        if (dto.getEmployeeId() != null) {
            entity.setEmployeeId(dto.getEmployeeId());
        }

        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }

        if (dto.getRemarks() != null) {
            entity.setRemarks(dto.getRemarks());
        }

        // date update
        if (dto.getDate() != null && !dto.getDate().isBlank()) {
            entity.setDate(LocalDate.parse(dto.getDate()));
        } else if (dto.getDate() != null && dto.getDate().isBlank()) {
            // explicit empty string -> null (if you want that behaviour)
            entity.setDate(null);
        }

        // inTime update
        if (dto.getInTime() != null && !dto.getInTime().isBlank()) {
            entity.setInTime(LocalTime.parse(dto.getInTime()));
        } else if (dto.getInTime() != null && dto.getInTime().isBlank()) {
            entity.setInTime(null);
        }

        // outTime update
        if (dto.getOutTime() != null && !dto.getOutTime().isBlank()) {
            entity.setOutTime(LocalTime.parse(dto.getOutTime()));
        } else if (dto.getOutTime() != null && dto.getOutTime().isBlank()) {
            entity.setOutTime(null);
        }

        return entity;
    }
}