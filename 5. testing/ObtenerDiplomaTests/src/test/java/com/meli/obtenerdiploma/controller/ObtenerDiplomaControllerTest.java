package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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
class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analyze valid student")
    void analyzeScores() {
        List<SubjectDTO> subjects = getSubjects("Química", 5d, "Historia", 10d);
        StudentDTO student = getStudent("Pedro", subjects);
        student.setAverageScore(7.5d);
        student.setMessage("Felicitaciones, aprobaste");
        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(student);

        StudentDTO studentOut = obtenerDiplomaController.analyzeScores(1L);

        verify(obtenerDiplomaService, atLeast(1)).analyzeScores(1L);
        assertEquals(7.5d, studentOut.getAverageScore());
        assertEquals("Felicitaciones, aprobaste", studentOut.getMessage());
    }

    private StudentDTO getStudent(String studentName, List<SubjectDTO> subjects) {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName(studentName);
        student.setSubjects(subjects);
        return student;
    }

    private List<SubjectDTO> getSubjects(
            String subjectName1,
            double scoreSubject1,
            String subjectName2,
            double scoreSubject2
    ) {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO(subjectName1, scoreSubject1));
        subjects.add(new SubjectDTO(subjectName2, scoreSubject2));
        return subjects;
    }


}