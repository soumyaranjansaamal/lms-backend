package com.lms.lms_backend.service;

import com.lms.lms_backend.entity.EducationInfo;

import java.util.Optional;

public interface EducationInfoService {

    EducationInfo create(EducationInfo info);

    EducationInfo getById(Long id);

    EducationInfo update(Long id, EducationInfo info);

    void delete(Long id);
}