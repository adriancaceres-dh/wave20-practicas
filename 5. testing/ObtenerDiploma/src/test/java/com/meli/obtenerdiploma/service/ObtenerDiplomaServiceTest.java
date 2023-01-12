package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest // Solo si se va a utilizar @Autowired
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Mock
    private IStudentDAO studentDAO;

    IObtenerDiplomaService objObtenerDiploma;
    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", null, null, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));

    @Test
    void analyzeScoresOfStudentNotExisting() {
        // Arrange
        Exception myException = new Exception();
        Exception exceptionExpected = new NullPointerException();
        // Act
        try {
            // Esto tira null pointer Exception porque tampoco tiene un try para el null.
            objObtenerDiploma.analyzeScores(studentDTOTest1.getId());

        } catch (NullPointerException ex) {
            myException = ex;
        }
        // Assert
        assertEquals(myException.getMessage(), exceptionExpected.getMessage());

    }

    @Disabled
    void analyzeScoreOfStudentWithinSubjects(){
        // Arrange
        StudentDTO studentDTOExpected = new StudentDTO();
        studentDTOExpected.setId(1L);
        studentDTOExpected.setStudentName("Pedro");
        studentDTOExpected.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));
        // Act

        // Assert
    }

    @Test
    void analyzeScoreOfStudentWithSubjectWithAverageLess9() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));

        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.";
        double expectedAverageScore = 7.333333333333333;
        //Act
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentDTOResponse = obtenerDiplomaService.analyzeScores(1L);

        //Asserts

        Assertions.assertEquals(expectedMessage, studentDTOResponse.getMessage());
        Assertions.assertEquals(expectedAverageScore, studentDTOResponse.getAverageScore());
    }

    @Test
    void analyzeScoreOfStudentWithSubjectWithAverageBetterThan9() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 10.0)
        )));

        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!";
        double expectedAverageScore = 9.3333333333333334;
        //Act
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentDTOResponse = obtenerDiplomaService.analyzeScores(1L);

        //Asserts
        Assertions.assertEquals(expectedMessage, studentDTOResponse.getMessage());
        Assertions.assertEquals(expectedAverageScore, studentDTOResponse.getAverageScore());
    }
}