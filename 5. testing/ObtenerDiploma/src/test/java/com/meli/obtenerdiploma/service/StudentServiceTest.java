package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {


    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;
    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDTO;
    private Set<StudentDTO> setStudentDto;

    public StudentServiceTest() {

        List<SubjectDTO> listSubjectDto = new ArrayList<>();
        listSubjectDto.add(SubjectDTO.builder().name("Prueba").score(2.0).build());
        listSubjectDto.add(SubjectDTO.builder().name("Prueba2").score(3.0).build());
        studentDTO =  StudentDTO.builder().id(1L).studentName("Juan").averageScore(2.0).message("Nuevo").averageScore(2.0).subjects(listSubjectDto).build();
        setStudentDto = new HashSet<>();
        setStudentDto.add(studentDTO);

    }

    @Test
    void testSave(){
        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        StudentDTO foundStudent = studentService.read(studentDTO.getId());

        assertNotNull(foundStudent);
        assertEquals(studentDTO.getStudentName(),foundStudent.getStudentName());
    }


    @Test
    void testFindAllStudents(){
        when(iStudentRepository.findAll()).thenReturn(setStudentDto);

        Set<StudentDTO> studentDTOSet = studentService.getAll();

        assertEquals(setStudentDto, studentDTOSet);

    }
}
