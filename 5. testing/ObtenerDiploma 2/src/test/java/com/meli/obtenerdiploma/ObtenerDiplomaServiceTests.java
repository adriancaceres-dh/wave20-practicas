package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest

class ObtenerDiplomaServiceTests {
    @Mock
    IStudentDAO iStudentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analizeScoresTestOk(){
        //Arrange
        SubjectDTO sub1 = new SubjectDTO("Lógica", 5.0);
        SubjectDTO sub2 = new SubjectDTO("Filosofía", 6.0);
        SubjectDTO sub3 = new SubjectDTO("Arte", 7.0);
        List<SubjectDTO> subjects = List.of(sub1, sub2, sub3);
        StudentDTO expected = new StudentDTO(2L,"Malena","El alumno Malena ha obtenido un promedio de 6. Puedes mejorar.",6.0,subjects);
        when(iStudentDAO.findById(2L)).thenReturn(new StudentDTO(2L,"Malena",null,null,subjects));
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);
        //Assert
        Assertions.assertEquals(expected.getMessage(),result.getMessage());
        Assertions.assertEquals(expected.getAverageScore(),result.getAverageScore());
    }

    @Test
    public void analizeScoresTestWithHonors(){
        //Arrange
        SubjectDTO sub1 = new
                SubjectDTO("Lógica", 10.0);
        SubjectDTO sub2 = new SubjectDTO("Filosofía", 10.0);
        SubjectDTO sub3 = new SubjectDTO("Arte", 10.0);
        List<SubjectDTO> subjects = List.of(sub1, sub2, sub3);
        StudentDTO expected = new StudentDTO(2L,"Lautaro","El alumno Lautaro ha obtenido un promedio de 10. Felicitaciones!",10.0,subjects);
        when(iStudentDAO.findById(2L)).thenReturn(new StudentDTO(2L,"Lautaro",null,null,subjects));
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);
        //Assert
        Assertions.assertEquals(expected.getMessage(),result.getMessage());
        Assertions.assertEquals(expected.getAverageScore(),result.getAverageScore());
    }

    @Test
    public void analizeScoresTestEmptySubjects(){
        //Arrange
        Long id = 2L;
        when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->obtenerDiplomaService.analyzeScores(id));
        verify(iStudentDAO,times(1)).findById(id);
    }
}