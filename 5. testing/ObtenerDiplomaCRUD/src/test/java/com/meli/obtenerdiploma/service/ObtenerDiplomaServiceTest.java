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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOK() {
        SubjectDTO[] subjectDTOS = {
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Química", 8.50)
        };
        StudentDTO  studentDTO = new StudentDTO(0L,
                "John Doe",
                null,
                null,
                List.of(subjectDTOS));
        Double promedioEsperado = (10.0 + 8.50) / 2.0;
        String mensajeEsperado = "El alumno John Doe ha obtenido un promedio de 9.25. Felicitaciones!";

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        StudentDTO studentAfterAnalizing = obtenerDiplomaService.analyzeScores(0L);
        assertEquals(promedioEsperado, studentAfterAnalizing.getAverageScore());
        assertEquals(mensajeEsperado, studentAfterAnalizing.getMessage());

    }
}