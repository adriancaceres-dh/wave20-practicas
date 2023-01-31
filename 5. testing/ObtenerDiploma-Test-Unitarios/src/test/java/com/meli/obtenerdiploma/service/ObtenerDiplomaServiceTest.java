package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analizeScoresTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Ciencia", 10.0));
        StudentDTO studentMock = new StudentDTO(1L, "Nombre", null, null, subjects);
        when(studentDAO.findById(1L)).thenReturn(studentMock);
        String messageExpected = "El alumno Nombre ha obtenido un promedio de 9. Puedes mejorar.";
        StudentDTO expected = new StudentDTO(1L, "Nombre", messageExpected, 9.0, subjects);


        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        Assertions.assertEquals(expected, result);
    }
}
