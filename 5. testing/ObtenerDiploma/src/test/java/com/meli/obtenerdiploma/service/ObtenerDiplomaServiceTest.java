package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Caso feliz - Se obtendría el objeto buscado con el correspondiente mensaje y promedio")
    void testAnalyzeScoresOK() {
        //Arrange
        StudentDTO studentExpected = new StudentDTO(1L, "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,
                List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        StudentDTO studentCopy = new StudentDTO(1L, "Juan",
                List.of(new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)));
        Long stuId = 1L;
        when(studentDAO.findById(stuId)).thenReturn(studentCopy);

        //Act
        StudentDTO studentResponse = obtenerDiplomaService.analyzeScores(stuId);

        //Assert
        Assertions.assertEquals(studentExpected, studentResponse);

    }

    @Test
    @DisplayName("Caso no feliz - Se obtendría una excepción del tipo StudentNotFound")
    void testAnalyzeScoresNotOK() {
        //Arrange
        Long stuId = 999L;
        String expectedMessage = "El alumno con Id " + stuId + " no se encuetra registrado.";
        when(studentDAO.findById(stuId)).thenThrow(StudentNotFoundException.class);

        //Act
        //StudentDTO studentResponse = obtenerDiplomaService.analyzeScores(stuId);
        StudentNotFoundException exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
            obtenerDiplomaService.analyzeScores(stuId);
        });
        String actualMessage = exception.getError().getDescription();

        //Assert
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

}