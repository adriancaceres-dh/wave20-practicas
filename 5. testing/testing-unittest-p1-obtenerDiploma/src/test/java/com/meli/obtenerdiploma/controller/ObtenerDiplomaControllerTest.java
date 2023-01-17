package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO std1;
    private SubjectDTO sbj1, sbj2;

    @BeforeEach
    public void arrange() {
        sbj1 = new SubjectDTO("Chino", 3D);
        sbj2 = new SubjectDTO("Alemán", 5D);
        std1 = new StudentDTO(1L, "Alicia", null, null, List.of(sbj1, sbj2));
    }

    @Test
    public void analyzeScoresTest() {
        obtenerDiplomaController.analyzeScores(std1.getId());
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(std1.getId());
    }
}
