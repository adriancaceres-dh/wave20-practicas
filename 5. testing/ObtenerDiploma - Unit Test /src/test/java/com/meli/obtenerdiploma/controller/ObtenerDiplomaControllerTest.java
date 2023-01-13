package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Camino feliz")
    void analyzeScoresOk() {
        //arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 8.0));
        StudentDTO studentExpected = new StudentDTO(3L, "Juan", "hola", 7.0, subjectDTOList);
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentExpected);
        //act
        StudentDTO studentDTOActual = obtenerDiplomaController.analyzeScores(anyLong());
        //assert
        assertEquals(studentExpected, studentDTOActual);
    }

    @Test
    void analyzeScoresStudentNotFoundException() {
        //arrange
        //act
        //assert
    }
}