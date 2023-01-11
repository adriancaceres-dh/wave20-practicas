package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.Mockito.atLeast;

@SpringBootTest
class StudentServiceTestSinMock {

    @Autowired
    private StudentService studentService;

    /*public StudentServiceTestSinMock() {
        StudentDAO studentDAO = new StudentDAO();
        StudentRepository studentRepository = new StudentRepository();
        this.studentService = new StudentService(studentDAO, studentRepository);
    }*/

    @Test
    @DisplayName("Crear estudiante correctamente")
    void createOk() {
        //arrange
        List<SubjectDTO> subjects = new ArrayList<>(List.of(
                new SubjectDTO("Matematica", 4.0),
                new SubjectDTO("Fisica", 4.6)

        ));
        StudentDTO studentExpected = new StudentDTO(3L,"Juan", "Hola soy juan", 4.3, subjects);

        //act
        studentService.create(studentExpected);
        //assert
        StudentDTO studentActual = studentService.read(3L);
        Assertions.assertEquals(studentExpected,studentActual);

    }

    @Test
    @DisplayName("Leer Estudiante")
    void readOk() {
        //arrange
        StudentDTO studentExpected = new StudentDTO(1L,"Juan","null",null,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matematica",9.0),
                        new SubjectDTO("Fisica",7.0),
                        new SubjectDTO("Química",6.0)
                )));

        //act
        StudentDTO studentActual = studentService.read(1L);

        //assert
        Assertions.assertEquals(studentExpected,studentActual);
    }

    @Test
    @DisplayName("Actualizando estudiante")
    void updateOk() {
        //arrange
        StudentDTO studentExpected = new StudentDTO(2L,"Juan","Hola soy juan",4.3,
                new ArrayList<>(List.of(
                        new SubjectDTO("Matematica",4.3),
                        new SubjectDTO("Fisica",4.6)
                )));

        //act
        studentService.update(studentExpected);
        StudentDTO studentActual = studentService.read(2L);

        //assert
        Assertions.assertEquals(studentExpected,studentActual);
    }

    @Test
    void deleteOk() {
        //arrange
        Integer sizeExpected = 1;

        //act
        studentService.delete(1L);
        Integer sizeActual = studentService.getAll().size();

        //assert
        Assertions.assertEquals(sizeExpected,sizeActual);
    }

    @Test
    void getAllOk() {
    }
}