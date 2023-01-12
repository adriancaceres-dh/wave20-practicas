package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;


import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTestConMock {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;
    @Test
    void analyzeScores(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        //Act
            obtenerDiplomaController.analyzeScores(studentDTO.getId());
        //Assert
        verify(service, atLeastOnce()).analyzeScores(studentDTO.getId());
    }



}
