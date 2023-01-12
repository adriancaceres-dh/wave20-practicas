package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StudentDaoTest {
    IStudentService studentService = new StudentService();

    @AfterEach
    void setup() {
        studentService.delete(3L);
    }



    @Test
    void createOK() {
        //arrange
        List<SubjectDTO> lista = new ArrayList<>();
        lista.add(new SubjectDTO("Matemáticas",7.4));
        StudentDTO expected = new StudentDTO(3L, "Alberto", "", 7.4, lista);

        //act
        studentService.create(expected);
        //assert
        StudentDTO actual = studentService.read(3L);
        assertEquals(expected, actual);
    }

    @Test
    void readOK() {
        //arrange
        List<SubjectDTO> lista = new ArrayList<>();
        lista.add(new SubjectDTO("Matemáticas",7.4));
        StudentDTO expected = new StudentDTO(3L, "Alberto", "", 7.4, lista);
        //act
        StudentDTO actual = studentService.read(3L);
        //assert

        assertEquals(expected,actual);
    }

    @Test
    void updateOK() {
        //arrange
        List<SubjectDTO> lista = new ArrayList<>();
        lista.add(new SubjectDTO("Matemáticas",7.4));
        StudentDTO expected = new StudentDTO(3L, "Alberto", "", 7.4, lista);
        //act
        studentService.update(expected);
        StudentDTO actual = studentService.read(3L);
        //assert
        assertEquals(expected,actual);
    }


}
