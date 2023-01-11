package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceMockTest {
    @Mock
    private StudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;
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
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        StudentDTO studentDTOResponse = obtenerDiplomaService.analyzeScores(1000L);

        //Asserts

        Assertions.assertEquals(expectedMessage,studentDTOResponse.getMessage());
        Assertions.assertEquals(expectedAverageScore,studentDTOResponse.getAverageScore());

    }
}
