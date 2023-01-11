package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentsDaoTest {

    private StudentService studentService;
    @Mock
    private IStudentDAO studentDAO; //interfaz

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService; //implementacion

    public StudentsDaoTest (){
        this.studentService = new StudentService();
        this.studentDAO = new StudentDAO();
        this.obtenerDiplomaService = new ObtenerDiplomaService();
    }

    @Test
    void calculateAverageTest(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",7.0));
        subjects.add(new SubjectDTO("Idioma español",5.0));
        StudentDTO studentDto = new StudentDTO(3L,"Tammara","Tiene que esforzarse un poco mas",3.0,subjects);

        studentService.create(studentDto);

        Double average = (7.0+5.0)/2.0; //deberia de dar promedio 6

        when(studentDAO.findById(anyLong())).thenReturn(studentDto); //para testear la excepcion se envia un numero de id que no exista y usar un asserthrow

        StudentDTO studentFind = obtenerDiplomaService.analyzeScores(3L);

        Assertions.assertEquals(average,studentFind.getAverageScore());
        Assertions.assertEquals("El alumno Tammara ha obtenido un promedio de 6. Puedes mejorar.",studentFind.getMessage());

    }

    

}
