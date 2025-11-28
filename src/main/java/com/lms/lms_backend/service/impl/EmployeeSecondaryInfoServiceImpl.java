package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.dto.EmployeeSecondaryInfoCreateDTO;
import com.lms.lms_backend.dto.EmployeeSecondaryInfoResponseDTO;
import com.lms.lms_backend.entity.EmployeeSecondaryInfo;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.mapper.EmployeeSecondaryInfoMapper;
import com.lms.lms_backend.repository.EmployeeSecondaryInfoRepository;
import com.lms.lms_backend.service.EmployeeSecondaryInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeSecondaryInfoServiceImpl implements EmployeeSecondaryInfoService {

    private final EmployeeSecondaryInfoRepository repository;

    public EmployeeSecondaryInfoServiceImpl(EmployeeSecondaryInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSecondaryInfoResponseDTO create(EmployeeSecondaryInfoCreateDTO dto) {
        EmployeeSecondaryInfo entity = EmployeeSecondaryInfoMapper.toEntity(dto);
        EmployeeSecondaryInfo saved = repository.save(entity);
        return EmployeeSecondaryInfoMapper.toDto(saved);
    }

    @Override
    public List<EmployeeSecondaryInfoResponseDTO> getByEmployeeId(Long employeeId) {
        List<EmployeeSecondaryInfo> list = repository.findByEmployeeId(employeeId);
        return list.stream().map(EmployeeSecondaryInfoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeSecondaryInfoResponseDTO getById(Long id) {
        EmployeeSecondaryInfo e = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("EmployeeSecondaryInfo not found with id " + id));
        return EmployeeSecondaryInfoMapper.toDto(e);
    }

    @Override
    public EmployeeSecondaryInfoResponseDTO update(Long id, EmployeeSecondaryInfoCreateDTO dto) {
        EmployeeSecondaryInfo e = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("EmployeeSecondaryInfo not found with id " + id));
        EmployeeSecondaryInfoMapper.updateEntity(e, dto);
        EmployeeSecondaryInfo saved = repository.save(e);
        return EmployeeSecondaryInfoMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EmployeeSecondaryInfo not found with id " + id);
        }
        repository.deleteById(id);
    }
}