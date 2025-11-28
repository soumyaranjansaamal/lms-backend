package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.entity.LeaveRequest;

import java.time.LocalDate;

public class LeaveMapper {

    public static LeaveRequest toEntity(LeaveCreateDTO dto) {
        if (dto == null) return null;
        LeaveRequest e = new LeaveRequest();
        e.setEmployeeId(dto.getEmployeeId());
        e.setType(dto.getType());
        e.setStatus(dto.getStatus() == null ? "PENDING" : dto.getStatus());
        e.setReason(dto.getReason());

        if (dto.getStartDate() != null && !dto.getStartDate().isBlank()) {
            e.setStartDate(LocalDate.parse(dto.getStartDate()));
        }

        if (dto.getEndDate() != null && !dto.getEndDate().isBlank()) {
            e.setEndDate(LocalDate.parse(dto.getEndDate()));
        }

        return e;
    }

    public static LeaveResponseDTO toDto(LeaveRequest e) {
        if (e == null) return null;
        LeaveResponseDTO dto = new LeaveResponseDTO();
        dto.setId(e.getId());
        dto.setEmployeeId(e.getEmployeeId());
        dto.setType(e.getType());
        dto.setStatus(e.getStatus());
        dto.setReason(e.getReason());
        dto.setStartDate(e.getStartDate());
        dto.setEndDate(e.getEndDate());
        return dto;
    }

    // required: updateEntity used by service's update method
    public static LeaveRequest updateEntity(LeaveRequest entity, LeaveCreateDTO dto) {
        if (entity == null || dto == null) return entity;

        if (dto.getEmployeeId() != null) entity.setEmployeeId(dto.getEmployeeId());
        if (dto.getType() != null) entity.setType(dto.getType());
        if (dto.getStatus() != null) entity.setStatus(dto.getStatus());
        if (dto.getReason() != null) entity.setReason(dto.getReason());

        if (dto.getStartDate() != null) {
            if (!dto.getStartDate().isBlank()) entity.setStartDate(LocalDate.parse(dto.getStartDate()));
            else entity.setStartDate(null);
        }

        if (dto.getEndDate() != null) {
            if (!dto.getEndDate().isBlank()) entity.setEndDate(LocalDate.parse(dto.getEndDate()));
            else entity.setEndDate(null);
        }

        return entity;
    }
}