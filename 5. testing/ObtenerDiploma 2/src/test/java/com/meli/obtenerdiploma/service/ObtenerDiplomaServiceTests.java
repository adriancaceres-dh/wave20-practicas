package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOk() {
        // arrange
        Long id = 10L;
        StudentDTO preProcessed = new StudentDTO(id, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(anyLong())).thenReturn(preProcessed);
        // act
        StudentDTO processed = obtenerDiplomaService.analyzeScores(id);
        // assert
        assertNotNull(processed.getAverageScore());
    }

    @Test
    void analyzeScoresEmptySubjects() {
        // arrange
        Long id = 10L;
        StudentDTO preProcessed = new StudentDTO(id, "Óscar", null, null, List.of());
        when(studentDAO.findById(anyLong())).thenReturn(preProcessed);
        // act
        StudentDTO processed = obtenerDiplomaService.analyzeScores(id);
        // assert
        assertTrue(Double.isNaN(processed.getAverageScore()));
    }
}
