package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {
    StudentRepository studentRepository = new StudentRepository();




    @Test
    public void findAllTest(){
        //Arrange
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(2L);
        studentDTO1.setStudentName("Pedro");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(1L);
        studentDTO2.setStudentName("Juan");
        studentDTO2.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química",6.0)
        )));

        Set<StudentDTO> studentsExpect = new HashSet<>();
        studentsExpect.add(studentDTO1);
        studentsExpect.add(studentDTO2);


        //Act

        Set<StudentDTO> studentsActual = studentRepository.findAll();

        //Assert
        Assertions.assertEquals(studentsExpect,studentsActual);
    }

}
