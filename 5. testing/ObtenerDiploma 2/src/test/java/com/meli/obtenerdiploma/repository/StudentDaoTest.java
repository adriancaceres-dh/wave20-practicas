package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StudentDaoTest {

    StudentDAO studentDAO = new StudentDAO();
    StudentRepository studentRepository = new StudentRepository();
    Long idTest = 3L;

    Set<StudentDTO> studentDTOSet;

    StudentDTO studentDTOTes = new StudentDTO(3L,"Carlos","hola",25.0,new ArrayList<>());
    //StudentDTO studentDTOTes2 = new StudentDTO(3L,"Carlos","hola",25.0,new ArrayList<>());

    @Test
    void readTestOk(){
        //arrange
        StudentDTO studentDTOtest = new StudentDTO();
        studentDTOtest.setId(2L);
        studentDTOtest.setStudentName("Pedro");
        studentDTOtest.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));
        StudentDTO expectedResult = studentDTOtest;
        //act
        StudentDTO actual = studentDAO.findById(studentDTOtest.getId());
        //assert
        Assertions.assertEquals(expectedResult,actual);
    }
    @Test
    void saveTestOk(){
        //arrange
        //no hace falta probar
        //act
        studentDAO.save(studentDTOTes);
        //assert
        Assertions.assertEquals(idTest,studentDTOTes.getId());
    }
    @Test
    void deleteTestOk(){
        //arrange
        boolean expectedResult = true;
        //act
        boolean actual =  studentDAO.delete(studentDTOTes.getId());
        //assert
        Assertions.assertTrue(expectedResult, String.valueOf(actual));
    }
    @Test
    void existsTestOk(){
        //arrange
        boolean expectedResult = false;
        //act
        boolean actual =studentDAO.exists(studentDTOTes);
        //assert
        Assertions.assertFalse(expectedResult, String.valueOf(actual));
    }


}
