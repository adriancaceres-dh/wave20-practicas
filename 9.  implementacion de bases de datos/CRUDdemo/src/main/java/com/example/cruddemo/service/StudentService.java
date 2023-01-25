package com.example.cruddemo.service;

import com.example.cruddemo.model.Student;
import com.example.cruddemo.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

  private final IStudentRepository studentRepository;

  public StudentService(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Student findStudent(Long id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public void saveStudent(Student student) {
    studentRepository.save(student);
  }

  @Override
  public Student updateStudent(Long id, String name, String lastName) {
    Student student = findStudent(id);
    student.setName(name);
    student.setLastName(lastName);
    return studentRepository.save(student);
  }

  @Override
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }
}
