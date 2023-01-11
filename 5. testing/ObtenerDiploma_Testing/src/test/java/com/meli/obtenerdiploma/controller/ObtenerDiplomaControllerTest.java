package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.Assert;
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
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        //Arrange
        Long id = 1L;
        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(createStudent());
        //Act
        StudentDTO studentToCompare =obtenerDiplomaController.analyzeScores(id);
        //Assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(id);
    }

    private StudentDTO createStudent() {

        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math", 5d));
        subjects.add(new SubjectDTO("Literature", 5d));
        student.setSubjects(subjects);

        return student;
    }
}