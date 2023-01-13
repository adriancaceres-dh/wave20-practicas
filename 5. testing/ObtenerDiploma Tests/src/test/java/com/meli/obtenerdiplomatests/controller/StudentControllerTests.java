package com.meli.obtenerdiplomatests.controller;

import com.meli.obtenerdiplomatests.exception.StudentNotFoundException;
import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.service.IStudentService;
import com.meli.obtenerdiplomatests.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentControllerTests {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Register student ok")
    public void registerStudentTest(){
        StudentDTO studentDTO = TestUtils.getStudentToSave();

        studentController.registerStudent(studentDTO);

        verify(studentService,atLeastOnce()).create(studentDTO);
    }

    @Test
    @DisplayName("Get student ok")
    public void getStudentOk(){
        long idToGet = 2;
        when(studentService.read(anyLong())).thenReturn(TestUtils.getStudentId2());
        StudentDTO expected = TestUtils.getStudentId2();


        StudentDTO result = studentController.getStudent(idToGet);

        Assertions.assertEquals(expected, result);
        verify(studentService,atLeastOnce()).read(idToGet);
    }

    @Test
    @DisplayName("Get student not found throw exception")
    public void getStudentException(){
        long idToGet = 2;
        when(studentService.read(anyLong())).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> {studentController.getStudent(idToGet);});

    }
}
