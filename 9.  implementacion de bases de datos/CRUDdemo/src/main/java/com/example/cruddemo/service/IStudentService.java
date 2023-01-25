package com.example.cruddemo.service;

import com.example.cruddemo.model.Student;

import java.util.List;

public interface IStudentService {
  public List<Student> getAllStudents();
  public Student findStudent(Long id);
  public void saveStudent(Student student);
  public Student updateStudent(Long id, String name, String lastName);
  public void deleteStudent(Long id);
}
