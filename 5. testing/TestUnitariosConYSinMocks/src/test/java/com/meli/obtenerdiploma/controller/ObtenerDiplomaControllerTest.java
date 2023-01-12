package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTestFound(){
        obtenerDiplomaController.analyzeScores(1L);
        verify(obtenerDiplomaService,atLeast(1)).analyzeScores(1L);
    }
    @Test
    public void analyzeScoresTestNotFound(){
        obtenerDiplomaController.analyzeScores(10L);
        verify(obtenerDiplomaService,atLeast(1)).analyzeScores(10L);
    }

}
