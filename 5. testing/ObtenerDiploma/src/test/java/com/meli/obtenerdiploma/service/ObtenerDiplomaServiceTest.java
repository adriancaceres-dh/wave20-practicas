package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    private StudentDAO studentDAO;

    IObtenerDiplomaService objObtenerDiploma;
    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest2 = new StudentDTO(2L, "Emanuel", "", 0.0, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 9.0)));

    @Test
    void analyzeScoresOfStudentNotExisting() throws StudentNotFoundException {
        // Arrange
        Exception myException = new NullPointerException();
        String messageExpected = "El alumno con Id " + studentDTOTest1.getId() + " no se encuetra registrado.";
        // Act
        try {
            // Esto tira null pointer Exception porque tampoco tiene un try para el null.
            objObtenerDiploma.analyzeScores(studentDTOTest1.getId());

        } catch (StudentNotFoundException ex) {
            myException = ex;
        }
        // Assert
        assertEquals(myException.getMessage(), messageExpected);
    }

    @Test
    void analyzeScoreOfStudentWithSubjectWithAverageLess9(){
        //StudentDTO userExpected = ;
    }


    @Test
    public void AnalyzeScoresTest(){
        //Arrange

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        String expectedMessage = "El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.";
        double expectedAverageScore = 7.333333333333333;
        //Act
        when(studentDAO.findById(1L)).thenReturn(studentDTO);

        StudentDTO studentDTOResponse = obtenerDiplomaService.analyzeScores(1L);

        //Asserts

        Assertions.assertEquals(expectedMessage,studentDTOResponse.getMessage());
        Assertions.assertEquals(expectedAverageScore,studentDTOResponse.getAverageScore());

    }
}