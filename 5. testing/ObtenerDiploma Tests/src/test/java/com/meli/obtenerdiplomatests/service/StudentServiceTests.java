package com.meli.obtenerdiplomatests.service;

import com.meli.obtenerdiplomatests.exception.StudentNotFoundException;
import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.model.SubjectDTO;
import com.meli.obtenerdiplomatests.repository.IStudentDAO;
import com.meli.obtenerdiplomatests.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    SubjectDTO sub1 = new SubjectDTO("Materia 1", 5d);
    SubjectDTO sub2 = new SubjectDTO("Materia 2", 1d);
    SubjectDTO sub3 = new SubjectDTO("Materia 3", 9d);
    StudentDTO studentDTO1 = new StudentDTO(1L, "Student1", "mensaje", 0d, List.of(sub1, sub2, sub3));

    StudentDTO studentDTO2 = new StudentDTO(1L, "Student1", "mensaje", 0d, List.of(sub3));

    @Test
    public void createTestOK(){

        // act
        studentService.create(studentDTO1);

        // assert
        verify(studentDAO,atLeast(1)).save(studentDTO1);
    }


    @Test
    public void readTestNotFoundException(){
        // arrange
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);
        // assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> {studentService.read(1L);});
    }
    @Test
    public void readTestFoundOK(){
        // arrange
        StudentDTO expected = new StudentDTO(1L, "Student1", "mensaje", 0d, List.of(sub1, sub2, sub3));
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO1);
        // act
        StudentDTO result = studentService.read(1L);
        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void updateTestOK(){
        // act
        studentService.update(studentDTO1);
        // assert
        verify(studentDAO,atLeast(1)).save(studentDTO1);
    }


    @Test
    public void deleteTestFoundOK() {
        // arrange
        Long idToDelete = 1L;
        // act
        studentService.delete(idToDelete);
        // assert
        verify(studentDAO, atLeastOnce()).delete(idToDelete);
    }

    @Test
    public void getAllTest(){
        // arrange
        when(studentRepository.findAll()).thenReturn(Set.of(studentDTO1, studentDTO2));
        int sizeExpected = 2;
        // act
        Set<StudentDTO> result = studentService.getAll();
        // assert
        Assertions.assertEquals(sizeExpected, result.size());
    }

}
