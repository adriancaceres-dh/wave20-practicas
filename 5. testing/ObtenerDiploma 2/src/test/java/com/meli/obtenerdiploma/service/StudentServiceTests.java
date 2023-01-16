package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createTestOk(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(studentDAO).save(studentDTO);
        //Act
        studentService.create(studentDTO);
        //Assert
        verify(studentDAO,times(1)).save(studentDTO);
    }

    @Test
    public void readTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(2L, null, null, null, null);
        when(studentDAO.findById(2L)).thenReturn(expected);
        //Act
        StudentDTO result = studentService.read(2L);
        //Assert
        verify(studentDAO,times(1)).findById(2L);
        Assertions.assertEquals(expected.getId(),result.getId());
    }
/*
    @Test
    public void readTestNotFound(){
        //Arrange
        when(studentDAO.findById(2L)).thenThrow(new StudentNotFoundException(2L));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->studentService.read(2L));
        verify(studentDAO,times(1)).findById(2L);
    }
 */
    @Test
    public void updateTestOk(){
        //Arrange
        StudentDTO student = new StudentDTO();
        doNothing().when(studentDAO).save(student);
        //Act
        studentService.update(student);
        //Assert
        verify(studentDAO,times(1)).save(student);
    }

    @Test
    public void deleteTestOk(){
        //Arrange
        Long id = 8L;
        when(studentDAO.delete(id)).thenReturn(true);
        //Act
        studentService.delete(id);
        //Assert
        verify(studentDAO,times(1)).delete(id);
    }

    @Test
    public void getAllTestOk(){
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        //Act
        Set<StudentDTO> result = studentService.getAll();
        //Assert
        verify(studentRepository,times(1)).findAll();
        Assertions.assertEquals(students,result);
    }
}
