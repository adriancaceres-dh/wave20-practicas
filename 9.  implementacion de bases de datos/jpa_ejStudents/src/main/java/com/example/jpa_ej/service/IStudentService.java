package com.example.jpa_ej.service;

import com.example.jpa_ej.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student stu);
    public void deleteStudent(Integer id);
    public Student findStudent(Integer id);
}
