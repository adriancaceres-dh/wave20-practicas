package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private StudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void whenAnalizesScoreThenGetTheCorrectAverageScoreAndMessage(){

        Long id = 1L;
        when(studentDAO.findById(id)).thenReturn(createStudent(4d, 8d));
        StudentDTO student = obtenerDiplomaService.analyzeScores(id);
        verify(studentDAO, atLeast(1)).findById(id);
        assertEquals(6, student.getAverageScore());
        assertEquals("El alumno Juan ha obtenido un promedio de 6. Puedes mejorar.", student.getMessage()
        );

    }

    @Test
    public void whenAttemptToAnalizeNonExistentStudentScoresThenThrowException(){

        Long id = 12L;
        when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        Exception exception = assertThrows(StudentNotFoundException.class, () ->
                obtenerDiplomaService.analyzeScores(id)
        );

        verify(studentDAO, atLeast(1)).findById(id);
        assertNotNull(exception);
    }

    private StudentDTO createStudent(double score1, double score2) {

        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", score1));
        subjects.add(new SubjectDTO("Literature", score2));
        student.setSubjects(subjects);

        return student;
    }


}
