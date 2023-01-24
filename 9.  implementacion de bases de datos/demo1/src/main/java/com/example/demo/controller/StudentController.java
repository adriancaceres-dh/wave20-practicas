package com.example.demo.controller;

import com.example.demo.service.IStudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  private final IStudentService studentService;

  public StudentController(IStudentService studentService) {
    this.studentService = studentService;
  }
}
