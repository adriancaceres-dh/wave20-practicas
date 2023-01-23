package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService mockObtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController injectMockObtenerDiplomaController;

    @Test
    @DisplayName("US-001 Controller Camino Feliz...")
    void analyzeScoreControllerTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        when(mockObtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudentDTO);
        //Act
        StudentDTO actualStudentDTO = injectMockObtenerDiplomaController.analyzeScores(studentId);
        //Assert
        Assertions.assertEquals(expectedStudentDTO, actualStudentDTO);
    }
}
