package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;
    @InjectMocks
    StudentController studentController;

    private List<SubjectDTO> subjects = new ArrayList<>(){{
        add(new SubjectDTO("sub1",5.0));
        add(new SubjectDTO("sub2",6.0));
        add(new SubjectDTO("sub3",7.0));
    }};
    private StudentDTO student= new StudentDTO(66L,"TestName",null,null,subjects);

    @Test
    public void registerStudentTestOk(){
        //Arrange
        doNothing().when(iStudentService).create(student);
        //Act
        ResponseEntity<?> response = studentController.registerStudent(student);
        //Assert
        Assertions.assertEquals(ResponseEntity.ok(null),response);
        verify(iStudentService,times(1)).create(student);
    }

    @Test
    public void getStudentTestOk(){
        //Arrange
        Long id = 44L;
        when(iStudentService.read(id)).thenReturn(student);
        //Act
        StudentDTO result = studentController.getStudent(id);
        //Assert
        Assertions.assertEquals(student,result);
        verify(iStudentService,times(1)).read(id);
    }

    @Test
    public void getStudentTestNotFound(){
        //Arrange
        Long id = 44L;
        when(iStudentService.read(id)).thenThrow(new StudentNotFoundException(id));
        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,()->studentController.getStudent(id));
        verify(iStudentService,times(1)).read(id);
    }

    @Test
    public void modifyStudentTestOk(){
        //Arrange
        doNothing().when(iStudentService).update(student);
        //Act
        ResponseEntity<?> response = studentController.modifyStudent(student);
        //Assert
        Assertions.assertEquals(ResponseEntity.ok(null),response);
        verify(iStudentService,times(1)).update(student);
    }

    @Test
    public void removeStudentOk(){
        //Arrange
        Long id = 44L;
        doNothing().when(iStudentService).delete(id);
        //Act
        ResponseEntity<?> result = studentController.removeStudent(id);
        //Assert
        Assertions.assertEquals(ResponseEntity.ok(null),result);
        verify(iStudentService,times(1)).delete(id);
    }

    @Test
    public void listStudentsOk(){
        //Arrange
        Set<StudentDTO> students = new HashSet<>(){{add(student);}};
        when(iStudentService.getAll()).thenReturn(students);
        //Act
        Set<StudentDTO> result = studentController.listStudents();
        //Assert
        Assertions.assertEquals(students,result);
        verify(iStudentService,times(1)).getAll();
    }

}
