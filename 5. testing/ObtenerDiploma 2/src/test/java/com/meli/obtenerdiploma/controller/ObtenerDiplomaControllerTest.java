package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.helper.StudentHelperTest;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void shouldAnalyzeBadScores() {
        //arrange
        StudentDTO expected = StudentHelperTest.getStudentWithBadScore("Pedro");
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 6. Puedes mejorar.");
        expected.setAverageScore(6.0);

        when(obtenerDiplomaService.analyzeScores(expected.getId()))
                .thenReturn(expected);
        //act
        StudentDTO actual = obtenerDiplomaController.analyzeScores(expected.getId());
        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAnalyzeGoodScores() {
        //arrange
        StudentDTO expected = StudentHelperTest.getStudentWithGoodScore("Pedro");
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!");
        expected.setAverageScore(10.0);

        when(obtenerDiplomaService.analyzeScores(expected.getId()))
                .thenReturn(expected);
        //act
        StudentDTO actual = obtenerDiplomaController.analyzeScores(expected.getId());
        //assert
        Assertions.assertEquals(expected, actual);
    }
}
