package com.meli.obtenerdiplomatests.service;

import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.repository.IStudentDAO;
import com.meli.obtenerdiplomatests.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements IStudentService {

    final
    IStudentDAO studentDAO;

    final
    IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository, IStudentDAO studentDAO) {
        this.studentRepository = studentRepository;
        this.studentDAO = studentDAO;
    }

    @Override
    public void create(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public void update(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
