package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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
public class ObtenerDiplomaControllerTests {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOk() {
        // arrange
        Long id = 10L;
        StudentDTO expected = new StudentDTO(10L, "Juan", "El alumno Juan ha obtenido un promedio de 10.00. Felicitaciones!", 10D, List.of(new SubjectDTO("Matemática", 10D), new SubjectDTO("Física", 10D), new SubjectDTO("Química", 10D)));
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(expected);
        // act
        StudentDTO actual = obtenerDiplomaController.analyzeScores(id);
        // assert
        assertEquals(expected, actual);
    }
}
