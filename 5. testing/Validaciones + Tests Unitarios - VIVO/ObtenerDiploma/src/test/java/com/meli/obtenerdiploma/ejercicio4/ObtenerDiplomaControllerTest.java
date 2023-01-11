package com.meli.obtenerdiploma.ejercicio4;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresOk() {
        // arrange
        long studentID = 1L;
        StudentDTO studentDTO = util.getStudent(studentID, "Juan", util.getSubjects(false));

        // act
        obtenerDiplomaController.analyzeScores(studentID);

        // assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(studentID);
    }
}
