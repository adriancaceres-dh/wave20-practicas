package com.bootcamp.testing.service.Interface;

import java.util.List;

import com.bootcamp.testing.dto.StudentResponseDto;

public interface IStudentService {
    public List<StudentResponseDto> getAllStudent();

    public StudentResponseDto findById(String id);
}
