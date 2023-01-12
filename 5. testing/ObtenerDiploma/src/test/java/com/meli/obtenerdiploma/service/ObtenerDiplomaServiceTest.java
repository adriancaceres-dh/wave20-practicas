package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO mockStudentDao;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    static StudentDTO student;

    @BeforeAll
    static void setup() {
        SubjectDTO sub1 = new SubjectDTO("mate",3.0);
        SubjectDTO sub2 = new SubjectDTO("español",5.0);
        List<SubjectDTO> subjects = Arrays.asList(sub1,sub2);
        student = new StudentDTO(4L,"Alberto","", (double) 0,subjects);
    }


    @Test
    @DisplayName("Caso ID nulo")
    void analyzeScoreNullId() {
        //arrange
        String expected = "El alumno con Id " + null + " no se encuetra registrado.";
        when(mockStudentDao.findById(null)).thenThrow(new StudentNotFoundException(null));

        //act
        Exception actual = assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(null));

        //assert
        assertEquals(expected, actual.getMessage());
    }

    @Test
    @DisplayName("Salida idéntica a la entrada")
    void analyzeScoreWithOnlyOneSubject() {
        //arrange
        double expected = 5;
        SubjectDTO sub2 = new SubjectDTO("español",5.0);
        List<SubjectDTO> subjects = Arrays.asList(sub2);
        StudentDTO student = new StudentDTO(4L,"Alberto","", (double) 0,subjects);
        when(mockStudentDao.findById(4L)).thenReturn(student);
        //act
        double actual = obtenerDiplomaService.analyzeScores(4L).getAverageScore();
        //assert
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Calculo de promedio")
    void analyzeScoreOK() {
        //arrange
        double expected = 4;
        when(mockStudentDao.findById(4L)).thenReturn(student);

        //act
        Double actual = obtenerDiplomaService.analyzeScores(4L).getAverageScore();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Leyenda del diploma")
    void analyzeScoreDiplomaMessage() {
        //arrange
        String expected = "El alumno " + "Alberto" + " ha obtenido un promedio de 4. Puedes mejorar.";
        when(mockStudentDao.findById(4L)).thenReturn(student);
        //act
        String actual = obtenerDiplomaService.analyzeScores(4L).getMessage();
        //assert
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Mensaje de diploma con honores")
    void analyzeScoreDiplomaHonorsMessage() {
        //arrange
        String expected = "El alumno " + "Alberto" + " ha obtenido un promedio de 10. Felicitaciones!";
        SubjectDTO sub1 = new SubjectDTO("mate",10.0);
        SubjectDTO sub2 = new SubjectDTO("español",10.0);
        List<SubjectDTO> subjects = Arrays.asList(sub1,sub2);
        StudentDTO student = new StudentDTO(4L,"Alberto","", (double) 0,subjects);
        when(mockStudentDao.findById(4L)).thenReturn(student);
        //act
        String actual = obtenerDiplomaService.analyzeScores(4L).getMessage();
        //assert
        assertEquals(expected, actual);
    }


}
