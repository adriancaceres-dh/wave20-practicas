package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;
    static StudentDTO generateStudentDTO(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 8.0));
        return new StudentDTO(3L, "Juan", "hola", 7.0, subjectDTOList);
    }

    @Test
    @DisplayName("Camino feliz")
    void registerStudentOk() {
        //arrange
        StudentDTO studentDTO = generateStudentDTO();
        //act
        studentController.registerStudent(studentDTO);
        //assert
        verify(studentService, atLeast(1)).create(studentDTO);

    }

    @Test
    void getStudentOk() {
        //arrange
        StudentDTO studentDTO = generateStudentDTO();
        when(studentService.read(anyLong())).thenReturn(studentDTO);
        //act
        StudentDTO studentActual = studentController.getStudent(studentDTO.getId());
        //assert
        assertEquals(studentDTO, studentActual);
    }

    @Test
    void modifyStudent() {
        //arrange
        StudentDTO studentDTO = generateStudentDTO();
        doNothing().when(studentService).update(studentDTO);
        //act
        studentService.update(studentDTO);
        //assert
        verify(studentService, atLeast(1)).update(studentDTO);
    }

    @Test
    void removeStudent() {
        //arrange
        StudentDTO studentDTO = generateStudentDTO();
        Mockito.doNothing().when(studentService).delete(anyLong());
        //act
        studentService.delete(studentDTO.getId());
        //assert
        verify(studentService, atLeast(1)).delete(studentDTO.getId());
    }

    @Test
    void listStudents() {
        //arrange
        Set<StudentDTO> studentDTOSetExpected = new HashSet<>();
        studentDTOSetExpected.add(generateStudentDTO());
        when(studentService.getAll()).thenReturn(studentDTOSetExpected);
        //act
        Set<StudentDTO> studentDTOSetActual = studentService.getAll();
        //assert
        assertEquals(studentDTOSetExpected, studentDTOSetActual);
    }
}