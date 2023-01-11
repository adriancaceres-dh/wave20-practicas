package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceMockTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void readTest(){

        //Arrange

        StudentDTO expectedstudentDTO = new StudentDTO();
        expectedstudentDTO.setId(1L);
        expectedstudentDTO.setStudentName("Pedro");
        expectedstudentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));
        studentDAO.save(expectedstudentDTO);


        StudentDTO actualStudentDto;

        //Act
        when(studentDAO.findById(1L)).thenReturn(expectedstudentDTO);

        actualStudentDto = studentService.read(1L);

        //Assert

        Assertions.assertEquals(expectedstudentDTO,actualStudentDto);

    }
  /* @Test
    public void getAll(){

        //Arrange
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(1L);
        studentDTO1.setStudentName("Pedro");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(2L);
        studentDTO2.setStudentName("Juan");
        studentDTO2.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(studentDTO1);
        studentDTOSet.add(studentDTO2);
        studentDTOSet.add(studentDTO);


        when(studentRepository.findAll()).thenReturn(studentDTOSet);
    }*/
}
