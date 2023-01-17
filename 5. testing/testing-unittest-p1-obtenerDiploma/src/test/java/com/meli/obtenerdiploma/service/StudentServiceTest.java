package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO std1;

    @BeforeEach
    public void arrange() {
        std1 = new StudentDTO(1L, "Alicia", null, null, null);
    }

    @Test
    public void createStudentTest() {
        studentService.create(std1);
        verify(studentDAO, atLeastOnce()).save(std1);
    }

    @Test
    public void readStudentTest() {
        when(studentDAO.findById(std1.getId())).thenReturn(std1);
        StudentDTO res = studentService.read(std1.getId());

        verify(studentDAO, atLeastOnce()).findById(std1.getId());
        assertEquals(std1, res);
    }

    @Test
    public void updateStudentTest() {
        studentService.update(std1);
        verify(studentDAO, atLeastOnce()).save(std1);
    }

    @Test
    public void deleteStudentTest() {
        studentService.delete(std1.getId());
        verify(studentDAO, atLeastOnce()).delete(std1.getId());
    }

    @Test
    public void getAllStudentsTest() {
        StudentDTO std2 = new StudentDTO(2L, "Benito", null, null, null );
        StudentDTO std3 = new StudentDTO(3L, "Camila", null, null, null );
        Set<StudentDTO> students = Set.of(std1, std2, std3);
        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> res = studentService.getAll();

        verify(studentRepository, atLeastOnce()).findAll();
        assertTrue(students.containsAll(res) && res.containsAll(students));
    }
}
