package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analizeScoresTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Ciencia", 10.0));
        String message = "El alumno Nombre ha obtenido un promedio de 9. Puedes mejorar.";
        StudentDTO student = new StudentDTO(1L, "Nombre", message, 9.0, subjects);
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);
        StudentDTO expected = new StudentDTO(1L, "Nombre", message, 9.0, subjects);

        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertEquals(expected, result);
    }
}
