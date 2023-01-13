package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceConMockTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    static StudentDTO generateStudentDTO(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 8.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 7.0));
        StudentDTO student = new StudentDTO(3L, "Juan", "", 7.5, subjectDTOList);
        student.setMessage("El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(student.getAverageScore())
                + ((student.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."));
        return student;
    }

    @Test
    @DisplayName("Camino feliz")
    void createOk() {
        //arrange
        StudentDTO student = generateStudentDTO();
        //act
        studentService.create(student);
        //assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    @DisplayName("Camino feliz")
    void readOk() {
        //arrange
        StudentDTO studentDTO = generateStudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);
        //act
        StudentDTO studentActual = studentService.read(anyLong());
        //assert
        assertEquals(studentDTO, studentActual);
    }

    @Test
    @DisplayName("Camino feliz")
    void updateOk() {
        //arrange
        StudentDTO student = generateStudentDTO();
        //act
        studentService.update(student);
        //assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    @DisplayName("Camino feliz")
    void deleteOk() {
        //arrange
        boolean expected = true;
        when(studentDAO.delete(anyLong())).thenReturn(expected);
        //act
        studentService.delete(anyLong());
        //assert
        verify(studentDAO, atLeast(1)).delete(anyLong());
    }


    @Test
    @DisplayName("Camino feliz")
    void getAll() {
        //arrange
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(generateStudentDTO());
        when(studentRepository.findAll()).thenReturn(studentDTOSet);
        //act
        Set<StudentDTO> studentDTOSetActual = studentService.getAll();
        //assert
        assertEquals(studentDTOSet, studentDTOSetActual);

    }
}