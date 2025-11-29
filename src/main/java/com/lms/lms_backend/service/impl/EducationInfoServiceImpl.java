package com.lms.lms_backend.service.impl;

import com.lms.lms_backend.entity.EducationInfo;
import com.lms.lms_backend.exception.ResourceNotFoundException;
import com.lms.lms_backend.repository.EducationInfoRepository;
import com.lms.lms_backend.service.EducationInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducationInfoServiceImpl implements EducationInfoService {

    private final EducationInfoRepository repository;

    public EducationInfoServiceImpl(EducationInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EducationInfo create(EducationInfo info) {
        return repository.save(info);
    }

    @Override
    @Transactional(readOnly = true)
    public EducationInfo getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationInfo not found with id: " + id));
    }

    @Override
    public EducationInfo update(Long id, EducationInfo info) {
        EducationInfo existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EducationInfo not found with id: " + id));

        // copy matching properties from incoming 'info' to 'existing' (skip id)
        BeanUtils.copyProperties(info, existing, "id");

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("EducationInfo not found with id: " + id);
        }
        repository.deleteById(id);
    }
}