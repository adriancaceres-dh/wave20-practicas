package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO std1;
    private SubjectDTO sbj1, sbj2, sbj3, sbj4, sbj5;

    @BeforeEach
    public void arrange() {
        std1 = new StudentDTO(1L, "Alicia", null, null, null);

        sbj1 = new SubjectDTO("Chino", 3D);
        sbj2 = new SubjectDTO("Alemán", 5D);
        sbj3 = new SubjectDTO("Francés", 8D);
        sbj4 = new SubjectDTO("Inglés", 9D);
        sbj5 = new SubjectDTO("Español", 10D);

        when(studentDAO.findById(std1.getId())).thenReturn(std1);
    }

    @Test
    public void returnLowAverageScore() {
        std1.setSubjects(List.of(sbj1, sbj2));
        Double expectedAverage = std1.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno Alicia ha obtenido un promedio de 4. Puedes mejorar.";

        StudentDTO res = obtenerDiplomaService.analyzeScores(std1.getId());
        assertEquals(expectedMessage, res.getMessage());
        assertEquals(expectedAverage, res.getAverageScore());
    }

    @Test
    public void returnLimitAverageScore() {
        std1.setSubjects(List.of(sbj3, sbj5));
        Double expectedAverage = std1.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno Alicia ha obtenido un promedio de 9. Puedes mejorar.";

        StudentDTO res = obtenerDiplomaService.analyzeScores(std1.getId());
        assertEquals(expectedMessage, res.getMessage());
        assertEquals(expectedAverage, res.getAverageScore());
    }

    @Test
    public void returnHighAverageScore() {
        std1.setSubjects(List.of(sbj4, sbj5));
        Double expectedAverage = std1.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        String expectedMessage = "El alumno Alicia ha obtenido un promedio de 9.5. Felicitaciones!";

        StudentDTO res = obtenerDiplomaService.analyzeScores(std1.getId());
        assertEquals(expectedMessage, res.getMessage());
        assertEquals(expectedAverage, res.getAverageScore());
    }
}
