package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EmployeeLeave;
import com.lms.lms_backend.repository.EmployeeLeaveRepository;
import com.lms.lms_backend.service.EmployeeLeaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    private final EmployeeLeaveRepository repo;

    public EmployeeLeaveServiceImpl(EmployeeLeaveRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeLeave saveLeave(EmployeeLeave leave) {
        // default status = PENDING if not set
        if (leave.getStatus() == null) {
            leave.setStatus("PENDING");
        }
        return repo.save(leave);
    }

    @Override
    public List<EmployeeLeave> getLeavesByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public EmployeeLeave approveLeave(Long leaveId) {
        Optional<EmployeeLeave> opt = repo.findById(leaveId);
        if (opt.isEmpty()) return null;
        EmployeeLeave l = opt.get();
        l.setStatus("APPROVED");
        return repo.save(l);
    }

    @Override
    public EmployeeLeave rejectLeave(Long leaveId) {
        Optional<EmployeeLeave> opt = repo.findById(leaveId);
        if (opt.isEmpty()) return null;
        EmployeeLeave l = opt.get();
        l.setStatus("REJECTED");
        return repo.save(l);
    }
}