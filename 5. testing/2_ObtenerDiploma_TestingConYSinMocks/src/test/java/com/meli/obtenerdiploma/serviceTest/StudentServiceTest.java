package com.meli.obtenerdiploma.serviceTest;

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
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(iStudentDAO).save(studentDTO);
        //Act
        studentService.create(studentDTO);
        //Assert
        verify(iStudentDAO,times(1)).save(studentDTO);
    }

    @Test
    public void readTestOk(){
        //Arrange
        Long id=2L;
        when(iStudentDAO.findById(id)).thenReturn(new StudentDTO());
        //Act
        StudentDTO result = studentService.read(id);
        //Assert
        verify(iStudentDAO,times(1)).findById(id);
        Assertions.assertEquals(StudentDTO.class,result.getClass());
    }

    @Test
    public void readTestNotFound(){
        //Arrange
        when(iStudentDAO.findById(2L)).thenThrow(new StudentNotFoundException(2L));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->studentService.read(2L));
        verify(iStudentDAO,times(1)).findById(2L);
    }
    @Test
    public void updateTest(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(iStudentDAO).save(studentDTO);
        //Act
        studentService.update(studentDTO);
        //Assert
        verify(iStudentDAO,times(1)).save(studentDTO);
    }

    @Test
    public void deleteTest(){
        //Arrange
        Long id = 8L;
        when(iStudentDAO.delete(id)).thenReturn(true);
        //Act
        studentService.delete(id);
        //Assert
        verify(iStudentDAO,times(1)).delete(id);
    }

    @Test
    public void deleteTestNotFound(){
        //Arrange
        Long id = 8L;
        when(iStudentDAO.delete(id)).thenReturn(false);
        //Act
        studentService.delete(id);
        //Assert
        verify(iStudentDAO,times(1)).delete(id);
    }

    @Test
    public void getAllTestOk(){
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        when(studentService.getAll()).thenReturn(students);
        //Act
        Set<StudentDTO> result = studentService.getAll();
        //Assert
        verify(iStudentRepository,times(1)).findAll();
        Assertions.assertEquals(students,result);
    }

}
