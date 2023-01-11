package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class StudentRepositoryTest {


    StudentRepository studentRepository;

    public StudentRepositoryTest() {

        studentRepository = new StudentRepository();
    }

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

        Set<StudentDTO> students_expect = new HashSet<>();
        students_expect.add(studentDTO1);
        students_expect.add(studentDTO2);

        Set<StudentDTO> students_actual;
        //Act

        students_actual = studentRepository.findAll();


        //Assert
        //Assertions.assertTrue(students_expect.equals(students_actual));
        Assertions.assertEquals(students_expect,students_actual);


    }

}
