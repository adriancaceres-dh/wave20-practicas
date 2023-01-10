package com.bootcamp.testing.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bootcamp.testing.dto.StudentResponseDto;
import com.bootcamp.testing.entity.Student;
import com.bootcamp.testing.repository.StudentRepository;
import com.bootcamp.testing.service.Interface.IStudentService;

@Service
public class StudentService implements IStudentService{

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponseDto> getAllStudent() {     
        return studentRepository.findAll().stream().map(s -> new StudentResponseDto(s)).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto findById(String id){
        Student student = studentRepository.findById(id);
        if(student == null) return null;
        return new StudentResponseDto(student);
    }
    
}
