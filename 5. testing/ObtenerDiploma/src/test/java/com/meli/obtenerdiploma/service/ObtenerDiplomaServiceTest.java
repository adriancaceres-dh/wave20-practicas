package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void shouldAnalyzeLowScore() {
        StudentDTO student = new StudentDTO(0L,
                "Anibal",
                null,
                null,
                List.of(new SubjectDTO("Quimica", 8D), new SubjectDTO("Algebra", 3D)));

        Double expectedScore = ((3D + 8D) / 2);
        String expectedMessage = "El alumno Anibal ha obtenido un promedio de 5.5. Puedes mejorar.";

        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO analyzedStudent = obtenerDiplomaService.analyzeScores(0L);
        verify(studentDAO, atLeastOnce()).findById(anyLong());
        assertEquals(expectedMessage, analyzedStudent.getMessage());
        assertEquals(expectedScore, analyzedStudent.getAverageScore());
    }

    @Test
    void shouldAnalyzeHighScore() {
        StudentDTO student = new StudentDTO(0L,
                "Anibal",
                null,
                null,
                List.of(new SubjectDTO("Quimica", 10D), new SubjectDTO("Algebra", 9D)));

        Double expectedScore = ((10D + 9D) / 2);
        String expectedMessage = "El alumno Anibal ha obtenido un promedio de 9.5. Felicitaciones!";

        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO analyzedStudent = obtenerDiplomaService.analyzeScores(0L);
        verify(studentDAO, atLeastOnce()).findById(anyLong());
        assertEquals(expectedMessage, analyzedStudent.getMessage());
        assertEquals(expectedScore, analyzedStudent.getAverageScore());
    }

}