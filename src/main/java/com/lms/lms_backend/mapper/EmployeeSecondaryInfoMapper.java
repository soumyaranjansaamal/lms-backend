package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryInfoResponseDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;

public class EmployeeSecondaryInfoMapper {

    public static EmployeeSecondaryInfo toEntity(EmployeeSecondaryInfoCreateDTO dto) {
        if (dto == null) return null;
        EmployeeSecondaryInfo e = new EmployeeSecondaryInfo();
        e.setEmployeeId(dto.getEmployeeId());
        e.setMaritalStatus(dto.getMaritalStatus());
        e.setSpouseName(dto.getSpouseName());
        e.setEmergencyContact(dto.getEmergencyContact());
        e.setFatherName(dto.getFatherName());
        e.setMotherName(dto.getMotherName());
        e.setBloodGroup(dto.getBloodGroup());
        e.setNationality(dto.getNationality());
        e.setReligion(dto.getReligion());
        return e;
    }

    public static EmployeeSecondaryInfoResponseDTO toDto(EmployeeSecondaryInfo e) {
        if (e == null) return null;
        EmployeeSecondaryInfoResponseDTO dto = new EmployeeSecondaryInfoResponseDTO();
        dto.setId(e.getId());
        dto.setEmployeeId(e.getEmployeeId());
        dto.setMaritalStatus(e.getMaritalStatus());
        dto.setSpouseName(e.getSpouseName());
        dto.setEmergencyContact(e.getEmergencyContact());
        dto.setFatherName(e.getFatherName());
        dto.setMotherName(e.getMotherName());
        dto.setBloodGroup(e.getBloodGroup());
        dto.setNationality(e.getNationality());
        dto.setReligion(e.getReligion());
        return dto;
    }

    public static void updateEntity(EmployeeSecondaryInfo entity, EmployeeSecondaryInfoCreateDTO dto) {
        if (entity == null || dto == null) return;
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setSpouseName(dto.getSpouseName());
        entity.setEmergencyContact(dto.getEmergencyContact());
        entity.setFatherName(dto.getFatherName());
        entity.setMotherName(dto.getMotherName());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setNationality(dto.getNationality());
        entity.setReligion(dto.getReligion());
        // note: employeeId usually shouldn't change on update, but if you want to allow it uncomment:
        // entity.setEmployeeId(dto.getEmployeeId());
    }
}