package com.meli.obtenerdiploma.testUnitarios.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTestWithMocks {


    @Mock
    private IStudentDAO mockStudentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("retornando studentDto con el calculo del promedio y un mensaje predeterminado")
    void analyzeScoresOK() {
        //Arrange
        Long id = 2L;
        StudentDTO stu = new StudentDTO(2L, "diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        when(mockStudentDAO.findById(id)).thenReturn(stu);
        //Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(id);
        //Assert
        Assertions.assertEquals(stu, actualStudent);

    }
    @Test
    @DisplayName("retornando studentDto con el calculo del promedio y un mensaje predeterminado" +
            "Dando un ID de estudiante inexistente")
    void analyzeScoresNotOK() {
        //Arrange
        Long id = 2L;
        StudentDTO stu = new StudentDTO(2L, "diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        when(mockStudentDAO.findById(id)).thenReturn(stu);
        //Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(id);
        //Assert
        Assertions.assertEquals(stu, actualStudent);
        verify(mockStudentDAO,atLeastOnce()).findById(id);

    }

    @Test
    @DisplayName("Retornando el mensaje conforme al promedio obtenido por el estudiante del ID " +
            "Pasado. Mensaje a setear= puede mejorar")
    void getGreetingMessageOK() {
        //Arrange
        String studentName = "Diego";
        Double average = 7.33;
        String expectedResponse = "El alumno Diego ha obtenido un promedio de " + 7.33
                +  ". Puedes mejorar.";
        //Act
        String actualResponse = obtenerDiplomaService.getGreetingMessage(studentName,average);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }
    @Test
    @DisplayName("Retornando el mensaje conforme al promedio obtenido por el estudiante del ID " +
            "Pasado. Mensaje a setear =Felicitaciones")
    void getGreetingMessageOKV2() {
        //Arrange
        String studentName = "Diego";
        Double average = 9.1;
        String expectedResponse = "El alumno Diego ha obtenido un promedio de " + 9.1
                +  ". Felicitaciones!";
        //Act
        String actualResponse = obtenerDiplomaService.getGreetingMessage(studentName,average);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);
    }

    @Test
    @DisplayName("devuelve el promedio del estudiante en cuestion")
    void calculateAverageOK(){
        //Arrange
        List<SubjectDTO> scores = List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 9.0),
                new SubjectDTO("Diseño", 9.0));
        Double expectedResponse = 9.0;

        //Act
        Double actualResponse = obtenerDiplomaService.calculateAverage(scores);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }
    @Test
    @DisplayName("devuelve el promedio del estudiante en cuestion")
    void calculateAverageNotOK(){
        //Arrange
        List<SubjectDTO> scores = new ArrayList<>();
        Double expectedResponse = NaN;

        //Act
        Double actualResponse = obtenerDiplomaService.calculateAverage(scores);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }
}
