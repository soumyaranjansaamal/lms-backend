package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.repository.EmployeeSecondaryInfoRepository;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeSecondaryInfoServiceImpl implements EmployeeSecondaryInfoService {

    private final EmployeeSecondaryInfoRepository repository;

    public EmployeeSecondaryInfoServiceImpl(EmployeeSecondaryInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSecondaryInfo create(EmployeeSecondaryInfoDTO dto) {
        // if unique by employeeId desired, check
        if (dto.getEmployeeId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "employeeId is required");
        }
        if (repository.existsByEmployeeId(dto.getEmployeeId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Secondary info already exists for employeeId: " + dto.getEmployeeId());
        }
        EmployeeSecondaryInfo entity = toEntity(dto);
        return repository.save(entity);
    }

    @Override
    public EmployeeSecondaryInfo update(Long id, EmployeeSecondaryInfoDTO dto) {
        EmployeeSecondaryInfo existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EmployeeSecondaryInfo not found with id: " + id));

        // update fields if present in dto
        if (dto.getEmployeeId() != null) existing.setEmployeeId(dto.getEmployeeId());
        existing.setFatherName(dto.getFatherName());
        existing.setMotherName(dto.getMotherName());
        existing.setBloodGroup(dto.getBloodGroup());
        existing.setNationality(dto.getNationality());
        existing.setMaritalStatus(dto.getMaritalStatus());
        existing.setAlternateContact(dto.getAlternateContact());
        existing.setEmergencyContact(dto.getEmergencyContact());
        existing.setNotes(dto.getNotes());

        return repository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmployeeSecondaryInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmployeeSecondaryInfo> findByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeSecondaryInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EmployeeSecondaryInfo not found with id: " + id);
        }
        repository.deleteById(id);
    }

    // simple mapper
    private EmployeeSecondaryInfo toEntity(EmployeeSecondaryInfoDTO dto) {
        EmployeeSecondaryInfo e = new EmployeeSecondaryInfo();
        e.setEmployeeId(dto.getEmployeeId());
        e.setFatherName(dto.getFatherName());
        e.setMotherName(dto.getMotherName());
        e.setBloodGroup(dto.getBloodGroup());
        e.setNationality(dto.getNationality());
        e.setMaritalStatus(dto.getMaritalStatus());
        e.setAlternateContact(dto.getAlternateContact());
        e.setEmergencyContact(dto.getEmergencyContact());
        e.setNotes(dto.getNotes());
        return e;
    }
}