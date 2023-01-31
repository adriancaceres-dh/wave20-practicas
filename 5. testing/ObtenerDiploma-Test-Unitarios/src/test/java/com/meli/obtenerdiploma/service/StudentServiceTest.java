package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void saveTest(){
        StudentDTO student = new StudentDTO(null, "Nombre", null, null, null);

        studentService.create(student);

        Mockito.verify(studentDAO, atLeast(1)).save(student);
    }

    @Test

    public void readTest(){
        StudentDTO student = new StudentDTO(11L, "nombre", null, null, new ArrayList<>());
        StudentDTO expected = new StudentDTO(11L, "nombre", null, null, new ArrayList<>());
        when(studentDAO.findById(11L)).thenReturn(student);

        StudentDTO result = studentService.read(11L);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void updateTest(){
        StudentDTO student = new StudentDTO(11L, "Nombre", null, null, null);

        studentService.update(student);

        Mockito.verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    public void deleteTest(){

        studentService.delete(1L);

        Mockito.verify(studentDAO, atLeast(1)).delete(1L);
    }

    @Test
    public void getAll(){
        List<SubjectDTO> subjectsMockList = new ArrayList<>();
        subjectsMockList.add(new SubjectDTO("Matematica", 8.0));
        Set<StudentDTO> studentMockList = new HashSet<>();
        studentMockList.add(new StudentDTO(1L, "nombre", null, null, subjectsMockList));
        studentMockList.add(new StudentDTO(2L, "nombre2", null, null, new ArrayList<>()));
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(new StudentDTO(1L, "nombre", null, null, subjectsMockList));
        expected.add(new StudentDTO(2L, "nombre2", null, null, new ArrayList<>()));
        when(studentRepository.findAll()).thenReturn(studentMockList);

        Set<StudentDTO> result = studentService.getAll();

        Assertions.assertEquals(expected, result);


    }
}
