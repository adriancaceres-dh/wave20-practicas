package com.example.practicaImplementacionBD.service;

import com.example.practicaImplementacionBD.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }
}
