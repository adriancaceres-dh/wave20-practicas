package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testRegisterStudent(){
        //Arrange
        List<SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(5L,"Camilo","Buen estudiante"
                , 4.0, subjectsDTOS );

        //Acton
        studentController.studentService.create(stu);

        //Assert
        verify(studentService,atLeastOnce()).create(stu);
    }

    @Test
    void  testGetStudent(){
        long query = 5L;
        List<SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(5L,"Camilo","Buen estudiante"
                , 4.0, subjectsDTOS );

        when(studentService.read(query)).thenReturn(stu);

        //Action
        StudentDTO studentResult = studentController.getStudent(query);

        //Assert
        assertNotNull(studentResult);
        assertEquals(stu.getStudentName(),studentResult.getStudentName());
    }

}