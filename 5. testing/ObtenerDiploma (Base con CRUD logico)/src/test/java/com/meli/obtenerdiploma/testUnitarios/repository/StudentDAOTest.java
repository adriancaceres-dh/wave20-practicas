package com.meli.obtenerdiploma.testUnitarios.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentDAOTest {

    private StudentDAO studentDAO;

    public StudentDAOTest() {
        studentDAO = new StudentDAO();
    }


    @Test
    @DisplayName("Guardando un estudiante")
        //Para esta prueba se requiere de mocks! (Método pasamanos)
    void saveStudentOK() {
        //Arrange
        boolean deleteExpected = true;
        StudentDTO stuInput = new StudentDTO(5L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        //Act
        studentDAO.save(stuInput);
        //Assert
        Assertions.assertTrue(studentDAO.exists(stuInput));


    }

    @Test
    @DisplayName("Eliminando un estudiante caso feliz")
    void deleteStudentOK() {
        //Arrange
        Long id = 1L;
        boolean expectedResponse = true;

        //Act
        boolean actualResponse = studentDAO.delete(id);

        //Assert
        Assertions.assertTrue(actualResponse);

    }

    @Test
    @DisplayName("Eliminando un estudiante caso triste")
    void deleteStudentNotOK() {
        //Arrange
        Long id = 4L;
        boolean expectedResponse = false;

        //Act
        boolean actualResponse = studentDAO.delete(id);

        //Assert
        Assertions.assertTrue(!actualResponse);
    }


    @Test
    @DisplayName("Chequeando si un usuario existe")
    void studentExistsOK() {
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        boolean result = studentDAO.exists(student);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Encontrar estudiante por ID")
    void findStudentByIdOK() {
        //Arrange
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));

        //Act
        StudentDTO studentActual = studentDAO.findById(studentExpected.getId());

        //Assert
        Assertions.assertEquals(studentExpected,studentActual);
    }

    @Test
    @DisplayName("Encontrar estudiante por un ID que no existe")
    void findStudentByIdNotOK() {
        //Arrange
        Long id = 10L;
        StudentNotFoundException exceptionExpected = new StudentNotFoundException(10L);
        //Act
        //Assert
        Assertions.assertThrows(exceptionExpected.getClass(),()->studentDAO.findById(id));
        }

}
