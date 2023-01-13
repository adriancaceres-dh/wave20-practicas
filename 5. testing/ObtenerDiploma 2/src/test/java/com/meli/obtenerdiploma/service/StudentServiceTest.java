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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {
        //arrange
        StudentDTO stu = getStudentDto();
        //act
        studentService.create(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    void read() {
        //arrange
        StudentDTO stu = getStudentDto();
        //act
        studentService.read(stu.getId());
        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
    }

    //SIMILARES A LOS ANTERIORES
    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    public StudentDTO getStudentDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("karen");
        studentDTO.setId(1L);
        studentDTO.setMessage("Mensaje de prueba");
        studentDTO.setAverageScore(4.25);
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematica");
        subjectDTO.setScore(9D);
        subjects.add(subjectDTO);
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}