package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Cannot analyze scores of a non-existent student")
    void Given_ANonExistentStudentId_When_AnalyzeHisScore_Then_IsNotPossible() {
        Long nonExistentId = 123L;
        when(studentDAO.findById(nonExistentId)).thenThrow(new StudentNotFoundException(nonExistentId));

        Exception exception = assertThrows(StudentNotFoundException.class, () ->
                obtenerDiplomaService.analyzeScores(nonExistentId)
        );

        verify(studentDAO, atLeast(1)).findById(nonExistentId);
        assertNotNull(exception);
    }

    @Test
    @DisplayName("Analyze score with regular grades")
    void Given_AnExistentStudentWithRegularGrades_When_AnalyzeHisScore_Then_ScoreAndDiplomaAreSet() {
        Long existentId = 1L;
        when(studentDAO.findById(existentId)).thenReturn(getStudent(7d, 9d));

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        verify(studentDAO, atLeast(1)).findById(existentId);
        assertEquals(8d, student.getAverageScore());
        assertEquals(
                "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.",
                student.getMessage()
        );
    }

    @Test
    @DisplayName("Analyze score with outstanding grades")
    void Given_AnExistentStudentWithOutstandingGrades_When_AnalyzeHisScore_Then_ScoreAndDiplomaAreSet() {
        Long existentId = 1L;
        when(studentDAO.findById(existentId)).thenReturn(getStudent(9d, 10d));

        StudentDTO student = obtenerDiplomaService.analyzeScores(1L);

        verify(studentDAO, atLeast(1)).findById(existentId);
        assertEquals(9.5, student.getAverageScore());
        assertEquals(
                "El alumno Juan ha obtenido un promedio de 9,5. Felicitaciones!",
                student.getMessage()
        );
    }

    private StudentDTO getStudent(double gradeSubject1, double gradeSubject2) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Química", gradeSubject1));
        subjects.add(new SubjectDTO("Física", gradeSubject2));
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }


}