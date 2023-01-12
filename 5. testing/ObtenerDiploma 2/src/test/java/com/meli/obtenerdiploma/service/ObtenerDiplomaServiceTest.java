package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.helper.StudentHelperTest;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void shouldAnalyzeBadScores() {
        //arrange
        StudentDTO expected = StudentHelperTest.getStudentWithBadScore("Pedro");
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 6. Puedes mejorar.");
        expected.setAverageScore(6.0);

        when(studentDAO.findById(expected.getId()))
                .thenReturn(StudentHelperTest.getStudentWithBadScore("Pedro"));
        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(expected.getId());
        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAnalyzeGoodScores() {
        //arrange
        StudentDTO expected = StudentHelperTest.getStudentWithGoodScore("Pedro");
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 10. Felicitaciones!");
        expected.setAverageScore(10.0);

        when(studentDAO.findById(expected.getId()))
                .thenReturn(StudentHelperTest.getStudentWithGoodScore("Pedro"));
        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(expected.getId());
        //assert
        Assertions.assertEquals(expected, actual);
    }
}
