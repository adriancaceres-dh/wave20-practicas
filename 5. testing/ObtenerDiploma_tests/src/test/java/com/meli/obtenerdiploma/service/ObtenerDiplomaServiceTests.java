package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOk() {
        // arrange
        Long id = 10L;
        Double average = 7.5;
        StudentDTO student = new StudentDTO(id, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(student.getId())).thenReturn(student);
        // act
        obtenerDiplomaService.analyzeScores(id);
        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertNotNull(student.getAverageScore());
        assertEquals(average, student.getAverageScore());
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

    @Test
    void analyzeScoresAbove9Message() {
        // arrange
        Long id = 10L;
        String expected = "El alumno Óscar ha obtenido un promedio de 9.5. Felicitaciones!";
        StudentDTO student = new StudentDTO(id, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(student.getId())).thenReturn(student);
        // act
        obtenerDiplomaService.analyzeScores(id);
        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(expected, student.getMessage());
    }

    @Test
    void analyzeScoresBelow9Message() {
        // arrange
        Long id = 10L;
        String expected = "El alumno Óscar ha obtenido un promedio de 7.5. Puedes mejorar.";
        StudentDTO student = new StudentDTO(id, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        when(studentDAO.findById(student.getId())).thenReturn(student);
        // act
        obtenerDiplomaService.analyzeScores(id);
        // assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(expected, student.getMessage());
    }
}
