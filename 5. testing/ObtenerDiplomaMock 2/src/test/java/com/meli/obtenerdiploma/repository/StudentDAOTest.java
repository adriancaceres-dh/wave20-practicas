package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    static IStudentDAO studentDAO ;
    StudentDTO studentDTO;
    IStudentRepository studentRepository;

    @BeforeEach
    void preCarga(){
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("armando");
        studentDTO.setId(0L);
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();
    }

    @Test
    void save() {
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
        assertNotNull(studentDAO.findById(studentDTO.getId()));
        assertEquals(studentDTO, studentDAO.findById(studentDTO.getId()));
        assertNotEquals(studentDTO, studentDAO.findById(1L));
    }


    @Test
    void delete() {
        if (!studentDAO.exists(studentDTO)) {
            studentDAO.save(studentDTO);
        }
        studentDAO.delete(studentDTO.getId());
        assertFalse(studentDAO.exists(studentDTO));
    }

    @AfterAll
    public static void cleanUp(){
        studentDAO.delete(0L);
    }

    @Test
    void exists() {
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void findById() {
        studentDAO.save(studentDTO);
        assertEquals(studentDTO, studentDAO.findById(0L));
    }
}