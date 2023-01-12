package com.meli.obtenerdiploma2.controller;

import com.meli.obtenerdiploma2.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma2.utils.StudentUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService mockObtenerDiplomeService;

    @InjectMocks
    ObtenerDiplomaController mockObtenerDiplomaController;

    @Test
    @DisplayName("Verificacion de invocacion adecuada analyze scores.")
    void shouldPassThroughAnalyzeScore() {
        //arrange
        //act
        mockObtenerDiplomaController.analyzeScores(19999L);
        //assert
        Mockito.verify(mockObtenerDiplomeService, atLeastOnce()).analyzeScores(19999L);
    }
}