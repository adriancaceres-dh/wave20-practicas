package com.example.jpa_ej.service;

import com.example.jpa_ej.entity.Student;
import com.example.jpa_ej.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public List<Student> getStudents() {
        return iStudentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveStudent(Student stu) {
        iStudentRepository.save(stu);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteStudent(Integer id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Integer id) {
        return iStudentRepository.findById(id).orElseGet(null);
    }
}
