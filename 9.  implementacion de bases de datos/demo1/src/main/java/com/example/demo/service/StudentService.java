package com.example.demo.service;

import com.example.demo.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
  private final IStudentRepository studentRepository;

  public StudentService(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }


}
