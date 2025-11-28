package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeSecondaryCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryResponseDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.mapper.EmployeeSecondaryMapper;
import com.lms.lms_backend.repository.EmployeeSecondaryRepository;
import com.lms.lms_backend.service.EmployeeSecondaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeSecondaryServiceImpl implements EmployeeSecondaryService {

    private final EmployeeSecondaryRepository repository;

    public EmployeeSecondaryServiceImpl(EmployeeSecondaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSecondaryResponseDTO create(EmployeeSecondaryCreateDTO dto) {
        EmployeeSecondaryInfo e = EmployeeSecondaryMapper.toEntity(dto);
        EmployeeSecondaryInfo saved = repository.save(e);
        return EmployeeSecondaryMapper.toDto(saved);
    }

    @Override
    public EmployeeSecondaryResponseDTO getById(Long id) {
        return repository.findById(id).map(EmployeeSecondaryMapper::toDto).orElse(null);
    }

    @Override
    public List<EmployeeSecondaryResponseDTO> getByEmployeeId(Long employeeId) {
        List<EmployeeSecondaryInfo> list = repository.findByEmployeeId(employeeId);
        return EmployeeSecondaryMapper.toDtoList(list);
    }

    @Override
    public EmployeeSecondaryResponseDTO update(Long id, EmployeeSecondaryCreateDTO dto) {
        return repository.findById(id).map(existing -> {
            // update fields
            existing.setMaritalStatus(dto.getMaritalStatus());
            existing.setSpouseName(dto.getSpouseName());
            existing.setEmergencyContact(dto.getEmergencyContact());
            existing.setFatherName(dto.getFatherName());
            existing.setMotherName(dto.getMotherName());
            existing.setBloodGroup(dto.getBloodGroup());
            existing.setNationality(dto.getNationality());
            existing.setReligion(dto.getReligion());
            // employeeId should generally not be changed, but if dto has it and you allow, set it:
            if (dto.getEmployeeId() != null) existing.setEmployeeId(dto.getEmployeeId());
            EmployeeSecondaryInfo updated = repository.save(existing);
            return EmployeeSecondaryMapper.toDto(updated);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (id != null && repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}