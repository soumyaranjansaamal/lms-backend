package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.EmployeeSecondaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryResponseDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSecondaryMapper {

    public static EmployeeSecondaryInfo toEntity(EmployeeSecondaryCreateDTO dto) {
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

    public static EmployeeSecondaryResponseDTO toDto(EmployeeSecondaryInfo e) {
        if (e == null) return null;
        EmployeeSecondaryResponseDTO dto = new EmployeeSecondaryResponseDTO();
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

    public static List<EmployeeSecondaryResponseDTO> toDtoList(List<EmployeeSecondaryInfo> list) {
        return list == null ? List.of() : list.stream().map(EmployeeSecondaryMapper::toDto).collect(Collectors.toList());
    }
}