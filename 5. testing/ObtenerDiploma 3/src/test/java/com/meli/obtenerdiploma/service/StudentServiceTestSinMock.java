package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

class StudentServiceTestSinMock {
    private StudentRepository studentRepository;
    private StudentDAO StudentDAO;
    private StudentService studentService;
    @BeforeEach
    void setUp(){
        StudentDAO = new StudentDAO();
        studentService = new StudentService();
        studentRepository = new StudentRepository();
    }
    @Test
    void create(){
        //arranger
        StudentDTO studentDTO = new StudentDTO();
        //act
        studentService.create(studentDTO);
        //assert
        //verify(StudentDAO, atLeast(1).save(studentDTO));

    }

    @Test
    void read() {
        //arranger
        /*StudentDTO studentDTO = new StudentDTO();

        //act

        StudentDTO actual = studentService.read(2L);
        StudentDTO result = StudentDAO.findById(2L);

        //assert
        assertEquals(actual,result);*/
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}