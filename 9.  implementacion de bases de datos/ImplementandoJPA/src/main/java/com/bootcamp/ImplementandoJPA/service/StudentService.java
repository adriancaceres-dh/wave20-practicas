package com.bootcamp.ImplementandoJPA.service;

import com.bootcamp.ImplementandoJPA.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
