package com.meli.obtenerdiploma.service;

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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService mockObtenerDiplomaService;

    @Test
    @DisplayName("US-001 Camino feliz...")
    void analyzeScoresTest() {
        //Arrange
        Long studentId = 5L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        when(studentDAO.findById(studentId))
                .thenReturn(expectedStudentDTO);

        //Act
        StudentDTO actualStudentDTO = mockObtenerDiplomaService.analyzeScores(expectedStudentDTO.getId());

        //Assert
        Assertions.assertEquals(expectedStudentDTO, actualStudentDTO);
    }
}
