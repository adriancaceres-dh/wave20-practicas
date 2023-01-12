package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {
    @InjectMocks
    StudentRepository studentRepository;
//    StudentDAO studentDAO = new StudentDAO();
    @Test
    public void findAllTest(){


        SubjectDTO subjectTest1 = new SubjectDTO("Matemática",9.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Física",7.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Química",6.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student1 = new StudentDTO(1L,"Juan", null,null,subjectList);

        SubjectDTO subjectTest4 = new SubjectDTO("Matemática",10.0);
        SubjectDTO subjectTest5 = new SubjectDTO("Física",8.0);
        SubjectDTO subjectTest6 = new SubjectDTO("Química",4.0);
        List<SubjectDTO> subjectList2 = Arrays.asList(subjectTest4,subjectTest5,subjectTest6);
        StudentDTO student2 = new StudentDTO(2L,"Pedro", null,null,subjectList2);

        Set<StudentDTO> studentsExpected = new HashSet<>();
        studentsExpected.add(student1);
        studentsExpected.add(student2);

        Set<StudentDTO> studentsActual;

        studentsActual = studentRepository.findAll();
        assertThat(studentsActual).usingRecursiveComparison().isEqualTo(studentsExpected);
    }
}
