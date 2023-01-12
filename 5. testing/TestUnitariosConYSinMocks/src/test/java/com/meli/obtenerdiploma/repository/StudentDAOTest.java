package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {
    @InjectMocks
    private StudentDAO studentDao;

    @Test
    public void deleteTestFoundId(){
        boolean actual = studentDao.delete(1L);
        Assertions.assertTrue(actual);
    }
    @Test
    public void deleteTestNotFoundId(){
        boolean actual = studentDao.delete(7L);
        Assertions.assertFalse(actual);
    }
    @Test
    public void existTestTrue(){
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",8.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",4.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(2L,"Pedro", null,null,subjectList);

        boolean actual = studentDao.exists(student);
        Assertions.assertTrue(actual);

    }
    @Test
    public void existTestFalse(){
        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",8.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",4.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(5L,"Pedro", null,null,subjectList);

        boolean actual = studentDao.exists(student);
        Assertions.assertFalse(actual);

    }
    @Test
    public void findByIdTest(){
        Long id = 2L;

        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",10.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",8.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",4.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO studentExpected = new StudentDTO(2L,"Pedro", null,null,subjectList);

        StudentDTO actual = studentDao.findById(id);
        Assertions.assertEquals(actual.getId(),studentExpected.getId());
        Assertions.assertEquals(actual.getStudentName(),studentExpected.getStudentName());
    }

}
