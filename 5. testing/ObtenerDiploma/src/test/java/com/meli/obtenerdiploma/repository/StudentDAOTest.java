package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.util.List;

@SpringBootTest
public class StudentDAOTest {

    private StudentDAO studentDAO;

    //Object StudentDTO
    StudentDTO studentDTO;

    public StudentDAOTest() {
        studentDAO = new StudentDAO();
        this.studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
    }

    @Test
    @DisplayName("US-001-Camino feliz...")
    @BeforeEach
    void existStudentDAOTest() {
        //Arrange
        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));

        //Act
        boolean result = studentDAO.exists(studentDTO2);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("US-002-Camino feliz...")
    @BeforeEach
    void findByIdStudentDAOTest() {
        //Arrange
        Long id = 1L;
        //Act
        StudentDTO actualStudentDTO = studentDAO.findById(id);
        //Assert
        Assertions.assertEquals(studentDTO, actualStudentDTO);
    }

    @Test
    @DisplayName("US-002- No se encontro el objeto por el id")
    @BeforeEach
    void noFindByIdStudentDAOTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(3L, "Pepe", List.of(
                new SubjectDTO("Matemática", 7.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 8.0)
        ));

        //Act and Assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    @DisplayName("US-003-Camino feliz...")
    void deleteStudentDAOTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0)
        ));
        //Act
        boolean result = studentDAO.delete(studentDTO.getId());
        System.out.println("Result: " + result);

        //Assert
        Assertions.assertTrue(result);

    }

}
