package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
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
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analizeScoresTestOk(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO("sub1",5.0));
            add(new SubjectDTO("sub2",6.0));
            add(new SubjectDTO("sub3",7.0));}};
        StudentDTO expected = new StudentDTO(2L,"Jaimito","El alumno Jaimito ha obtenido un promedio de 6. Puedes mejorar.",6.0,subjects);
        when(iStudentDAO.findById(2L)).thenReturn(new StudentDTO(2L,"Jaimito",null,null,subjects));
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);
        //Assert
        Assertions.assertEquals(expected.getMessage(),result.getMessage());
        Assertions.assertEquals(expected.getAverageScore(),result.getAverageScore());
    }

    @Test
    public void analizeScoresTestWithHonors(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>(){{
            add(new SubjectDTO("sub1",10.0));
            add(new SubjectDTO("sub2",10.0));
            add(new SubjectDTO("sub3",10.0));}};
        StudentDTO expected = new StudentDTO(2L,"Jaimito","El alumno Jaimito ha obtenido un promedio de 10. Felicitaciones!",10.0,subjects);
        when(iStudentDAO.findById(2L)).thenReturn(new StudentDTO(2L,"Jaimito",null,null,subjects));
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(2L);
        //Assert
        Assertions.assertEquals(expected.getMessage(),result.getMessage());
        Assertions.assertEquals(expected.getAverageScore(),result.getAverageScore());
    }

    @Test
    public void analizeScoresTestEmptySubjects(){
        //Arrange
        Long id= 2L;
        when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->obtenerDiplomaService.analyzeScores(id));
        verify(iStudentDAO,times(1)).findById(id);
    }
}
