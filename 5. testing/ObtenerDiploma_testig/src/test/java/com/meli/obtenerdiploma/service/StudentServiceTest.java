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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    Set<StudentDTO> studentDTOSetTest;


    public StudentServiceTest(){
        studentDTOSetTest = new HashSet<>();

        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(2L);
        studentDTO1.setStudentName("Pedro");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(1L);
        studentDTO2.setStudentName("Juan");
        studentDTO2.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        studentDTOSetTest.add(studentDTO1);
        studentDTOSetTest.add(studentDTO2);
    }

    @Test
    public void createTestShouldCreateAStudent(){
        //Arrange
        StudentDTO studentDTO = studentDTOSetTest.stream().filter(e -> e.getId() == 1L).findFirst().get();

        //act
        studentService.create(studentDTO);
        //
        verify(studentDAO,atLeast(1)).save(studentDTO);
    }

    @Test
    public void readTest(){

        //Arrange
        StudentDTO expectedStudentDTO = studentDTOSetTest.stream().filter(e -> e.getId() == 1L).findFirst().get();

        StudentDTO actualStudentDTO;
        //Act
        when(studentDAO.findById(expectedStudentDTO.getId())).thenReturn(expectedStudentDTO);
        actualStudentDTO = studentService.read(expectedStudentDTO.getId());
        //Assert
        verify(studentDAO,atLeast(1)).findById(expectedStudentDTO.getId());
        Assertions.assertEquals(expectedStudentDTO,actualStudentDTO);
    }

    @Test
    public void updateTestShouldUpdateAStudent(){
        //Arrange
        StudentDTO studentDTO = studentDTOSetTest.stream().filter(e -> e.getId() == 1L).findFirst().get();

        //act
        studentService.update(studentDTO);
        //
        verify(studentDAO,atLeast(1)).save(studentDTO);
    }

    @Test
    public void deleteTestShouldDeleteAStudent(){
        //Arrange
        long id = 1L;
        //act
        studentService.delete(id);
        //
        verify(studentDAO,atLeast(1)).delete(1L);
    }

    @Test
    public void getAllTestShouldReturnAStudentDTOSet(){

        //Arrange
        Set<StudentDTO> expectedStudentDTOSet = studentDTOSetTest;
        Set<StudentDTO> actualStudentDTOSet;

        when(studentRepository.findAll()).thenReturn(expectedStudentDTOSet);

        //act

        actualStudentDTOSet = studentService.getAll();

        //Assert
        verify(studentRepository, atLeast(1)).findAll();
        Assertions.assertEquals(expectedStudentDTOSet,actualStudentDTOSet);

    }
}
