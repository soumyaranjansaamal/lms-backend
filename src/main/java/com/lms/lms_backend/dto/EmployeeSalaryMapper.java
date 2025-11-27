package com.lms.lms_backend.mapper;

import com.lms.lms_backend.dto.EmployeeSalaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSalaryResponseDTO;
import com.lms.lms_backend.entity.EmployeeSalary;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeSalaryMapper {

    private EmployeeSalaryMapper() {}

    public static EmployeeSalary toEntity(EmployeeSalaryCreateDTO dto) {
        if (dto == null) return null;
        EmployeeSalary e = new EmployeeSalary();
        e.setEmployeeId(dto.getEmployeeId());
        e.setBasic(dto.getBasic());
        e.setAllowances(dto.getAllowances());
        e.setDeductions(dto.getDeductions());
        // compute total if not provided
        if (dto.getTotalSalary() != null) {
            e.setTotalSalary(dto.getTotalSalary());
        } else {
            java.math.BigDecimal b = dto.getBasic() == null ? java.math.BigDecimal.ZERO : dto.getBasic();
            java.math.BigDecimal a = dto.getAllowances() == null ? java.math.BigDecimal.ZERO : dto.getAllowances();
            java.math.BigDecimal d = dto.getDeductions() == null ? java.math.BigDecimal.ZERO : dto.getDeductions();
            e.setTotalSalary(b.add(a).subtract(d));
        }
        e.setMonth(dto.getMonth());
        e.setYear(dto.getYear());
        return e;
    }

    public static EmployeeSalaryResponseDTO toDto(EmployeeSalary e) {
        if (e == null) return null;
        return EmployeeSalaryResponseDTO.builder()
                .id(e.getId())
                .employeeId(e.getEmployeeId())
                .basic(e.getBasic())
                .allowances(e.getAllowances())
                .deductions(e.getDeductions())
                .totalSalary(e.getTotalSalary())
                .month(e.getMonth())
                .year(e.getYear())
                .build();
    }

    public static List<EmployeeSalaryResponseDTO> toDtoList(List<EmployeeSalary> list) {
        if (list == null) return java.util.Collections.emptyList();
        return list.stream().map(EmployeeSalaryMapper::toDto).collect(Collectors.toList());
    }
}