package com.meli.obtenerdiploma.ejercicio2;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.util;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOk() {
        //arrange
        Long studentId = 1L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO res = util.getStudent(studentId, "Luis", subjects);
        when(studentDAO.findById(studentId)).thenReturn(res);

        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(res.getId());

        //assert
        Assertions.assertEquals(res, actual);
    }

    @Test
    void calculateAverageOk() {
        //arrange
        Long studentId = 2L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO res = util.getStudent(studentId, "Antonio", subjects);
        double avg = subjects.stream()
                .reduce(0D, (partialSum, s) -> partialSum + s.getScore(), Double::sum)
                / subjects.size();
        when(studentDAO.findById(studentId)).thenReturn(res);

        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(res.getId());

        //assert
        verify(studentDAO, atLeastOnce()).findById(res.getId());
        Assertions.assertEquals(avg, actual.getAverageScore());
    }

    @Test
    @DisplayName("Verificar mensaje cuando tiene un promedio menor a 9")
    void getGreetingMessageBelow9PointsOk() {
        //arrange
        Long studentId = 3L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO res = util.getStudent(studentId, "Pedro", subjects);
        double avg = subjects.stream()
                .reduce(0D, (partialSum, s) -> partialSum + s.getScore(), Double::sum)
                / subjects.size();
        when(studentDAO.findById(studentId)).thenReturn(res);
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(avg) + ". Puedes mejorar.";
        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(res.getId());

        //assert
        Assertions.assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    @DisplayName("Verificar mensaje cuando tiene un promedio mayor a 9")
    void getGreetingMessageAbove9PointsOk() {
        //arrange
        Long studentId = 3L;
        List<SubjectDTO> subjects = util.getSubjects(true);
        StudentDTO res = util.getStudent(studentId, "Pedro", subjects);
        double avg = subjects.stream()
                .reduce(0D, (partialSum, s) -> partialSum + s.getScore(), Double::sum)
                / subjects.size();
        when(studentDAO.findById(studentId)).thenReturn(res);
        String expectedMessage = "El alumno Pedro ha obtenido un promedio de " +
                new DecimalFormat("#.##").format(avg) + ". Felicitaciones!";
        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(res.getId());
        //assert
        Assertions.assertEquals(expectedMessage, actual.getMessage());
    }


}
