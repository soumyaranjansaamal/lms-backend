package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;
import com.lms.lms_backend.entity.LeaveRequest;

import java.time.LocalDate;

/**
 * Mapper between LeaveCreateDTO <-> LeaveRequest entity and LeaveResponseDTO.
 *
 * This version expects DTO methods:
 *  - LeaveCreateDTO.getEmployeeId()
 *  - LeaveCreateDTO.getType()        (string)
 *  - LeaveCreateDTO.getStartDate()   (string yyyy-MM-dd)
 *  - LeaveCreateDTO.getEndDate()     (string yyyy-MM-dd)
 *  - LeaveCreateDTO.getStatus()
 *  - LeaveCreateDTO.getReason()
 *
 * And response DTO has setType(...) and setStartDate(LocalDate) etc.
 */
public class EmployeeLeaveMapper {

    // DTO -> Entity (new)
    public static LeaveRequest toEntity(LeaveCreateDTO dto) {
        if (dto == null) return null;
        LeaveRequest e = new LeaveRequest();

        e.setEmployeeId(dto.getEmployeeId());
        e.setType(dto.getType() != null ? dto.getType() : null);
        e.setStatus(dto.getStatus() != null ? dto.getStatus() : "PENDING");
        e.setReason(dto.getReason());

        // parse startDate (String -> LocalDate)
        if (dto.getStartDate() != null && !dto.getStartDate().isBlank()) {
            e.setStartDate(LocalDate.parse(dto.getStartDate()));
        } else {
            e.setStartDate(null);
        }

        // parse endDate (String -> LocalDate)
        if (dto.getEndDate() != null && !dto.getEndDate().isBlank()) {
            e.setEndDate(LocalDate.parse(dto.getEndDate()));
        } else {
            e.setEndDate(null);
        }

        return e;
    }

    // Entity -> DTO (response)
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

    // Update an existing entity using values from DTO (used by service update)
    public static LeaveRequest updateEntity(LeaveRequest entity, LeaveCreateDTO dto) {
        if (entity == null || dto == null) return entity;

        // update scalar fields only if DTO provides non-null (client intent)
        if (dto.getEmployeeId() != null) {
            entity.setEmployeeId(dto.getEmployeeId());
        }

        if (dto.getType() != null) {
            entity.setType(dto.getType());
        }

        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }

        if (dto.getReason() != null) {
            entity.setReason(dto.getReason());
        }

        // update startDate (string -> LocalDate)
        if (dto.getStartDate() != null) {
            if (!dto.getStartDate().isBlank()) {
                entity.setStartDate(LocalDate.parse(dto.getStartDate()));
            } else {
                // explicit empty string means clear the date
                entity.setStartDate(null);
            }
        }

        // update endDate (string -> LocalDate)
        if (dto.getEndDate() != null) {
            if (!dto.getEndDate().isBlank()) {
                entity.setEndDate(LocalDate.parse(dto.getEndDate()));
            } else {
                entity.setEndDate(null);
            }
        }

        return entity;
    }
}