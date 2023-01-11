package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.StudentDTOUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    void create() {
        StudentDTO studentDTO = StudentDTOUtil.createStudentWithSubject();
        studentService.create(studentDTO);
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void readWhenIdExists() {
        StudentDTO studentDTO = StudentDTOUtil.createStudentWithSubject();
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);
        assertNotNull(studentService.read(anyLong()));
        verify(studentDAO, times(1)).findById(anyLong());
    }

    @Test
    void readWhenIdDoesNotExist() {
        Long unexistantId = 1024L;
        when(studentDAO.findById(unexistantId)).thenThrow(new StudentNotFoundException(unexistantId));
        assertThrows(StudentNotFoundException.class, () -> studentService.read(unexistantId));
        verify(studentDAO, times(1)).findById(unexistantId);
    }

    @Test
    void update() {
        StudentDTO studentDTO = StudentDTOUtil.createStudentWithSubject();
        studentService.update(studentDTO);
        verify(studentDAO,  times(1)).save(studentDTO);
    }

    @Test
    void delete() {
        Long id = 1L;
        studentService.delete(id);
        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    void getAll() {
        Set<StudentDTO> expectedStudents = Set.of(
                StudentDTOUtil.createStudentWithSubject(),
                StudentDTOUtil.createStudentWithSubject()
        );
        when(studentRepository.findAll()).thenReturn(expectedStudents);
        Set<StudentDTO> result = studentService.getAll();
        verify(studentRepository, times(1)).findAll();
        assertEquals(expectedStudents, result);
    }
}