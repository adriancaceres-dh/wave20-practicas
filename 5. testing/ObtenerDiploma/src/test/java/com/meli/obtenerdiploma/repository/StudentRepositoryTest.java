package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDAO studentDAO;

    /*@BeforeEach
    void helloServiceTest() {
        this.studentRepository = new StudentRepository();
        this.studentDAO = new StudentDAO();
    }

     */

    @Test
    @DisplayName("US-001 Camino feliz...")
    void finAllTest() {
        //Arrange
        Set<StudentDTO> expectedLoadData = new HashSet<>();
        StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        expectedLoadData.add(studentDTO1);
        //studentDAO.save(studentDTO1);

        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)));
        expectedLoadData.add(studentDTO2);
        //studentDAO.save(studentDTO2);

        System.out.println("expectedLoadData = " + expectedLoadData);

        //Act
        Set<StudentDTO> actualLoadData = studentRepository.findAll();
        System.out.println("Actual Value: " + actualLoadData);
        //Assert
        Assertions.assertEquals(expectedLoadData, actualLoadData);
        Assertions.assertEquals(expectedLoadData.size(), actualLoadData.size());
        //assertThat(actualLoadData).containsALL(expectedLoadData);
    }

    @Test
    @DisplayName("US-001 No carga el Json...")
    void findAllExceptionTest() {
        //Arrange
        Set<StudentDTO> expectedLoadData = null;

        //Act

        //Assert
        //Assertions.assertThrows(FileNotFoundException.class, () -> );
    }
}
