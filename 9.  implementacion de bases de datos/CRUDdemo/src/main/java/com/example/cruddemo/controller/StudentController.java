package com.example.cruddemo.controller;

import com.example.cruddemo.model.Student;
import com.example.cruddemo.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
  private final IStudentService studentService;

  public StudentController(IStudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/create")
  public String createStudent(@RequestBody Student student) {
    studentService.saveStudent(student);
    return "Student created";
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping("edit/{id}")
  public Student editStudent(@PathVariable long id,
                             @RequestParam ("name") String newName,
                             @RequestParam ("lastname") String newLastName) {
    return studentService.updateStudent(id, newName, newLastName);
  }

  @PostMapping("delete/{id}")
  public String deleteStudent(@PathVariable long id) {
    studentService.deleteStudent(id);
    return "Student deleted";
  }
}
