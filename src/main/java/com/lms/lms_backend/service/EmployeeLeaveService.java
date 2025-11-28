package com.lms.lms_backend.service;

import com.lms.lms_backend.dto.LeaveCreateDTO;
import com.lms.lms_backend.dto.LeaveResponseDTO;

import java.util.List;

public interface EmployeeLeaveService {

    LeaveResponseDTO applyLeave(LeaveCreateDTO dto);

    LeaveResponseDTO getLeave(Long id);

    List<LeaveResponseDTO> getLeavesByEmployee(Long employeeId);

    LeaveResponseDTO approveLeave(Long id);

    LeaveResponseDTO rejectLeave(Long id);

    void deleteLeave(Long id);
}