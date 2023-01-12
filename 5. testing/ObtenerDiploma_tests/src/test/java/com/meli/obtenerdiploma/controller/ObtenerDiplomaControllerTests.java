package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOk() {
        // arrange
        Long id = 10L;
        StudentDTO expected = new StudentDTO(id, "Juan", "El alumno Juan ha obtenido un promedio de 10.00. Felicitaciones!", 10D, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 10D), new SubjectDTO("Química", 10D)));
        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(expected);
        // act
        StudentDTO actual = obtenerDiplomaController.analyzeScores(id);
        // assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(id);
        assertEquals(expected, actual);
    }
}
