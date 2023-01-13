package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    IStudentDAO studentDAO = new StudentDAO();
    StudentDTO studentDTO;
    IStudentRepository studentRepository = new StudentRepository();
    StudentService studentService = new StudentService();
    @Test
    void update() {
        String expect = "Javiera";
        studentDTO = studentRepository.findAll().stream().filter(x->x.getId()==0).findFirst().get();
        assertNotEquals(studentDTO.getStudentName(), expect);
        studentDTO.setStudentName(expect);
        studentService.update(studentDTO);
        studentDTO = studentRepository.findAll().stream().filter(x->x.getId()==0).findFirst().get();
        assertEquals(studentDTO.getStudentName(), expect);

    }
}