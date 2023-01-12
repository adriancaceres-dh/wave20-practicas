package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;

@ExtendWith(MockitoExtension.class)

class StudentServiceTest {
    SubjectDTO Maths;
    List<SubjectDTO> subjectDTOList;
    StudentDTO stu;

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setup() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO Maths = new SubjectDTO("Matematicas", 9.5);
        subjectDTOList.add(Maths);
    }

    @Test
    void create() {
        //Arrange
        StudentDTO stu=new StudentDTO();
        //Act
        studentService.create(stu);

        //Assert
        verify(studentDAO,atLeast(1)).save(stu);
    }

    @Test
    void read() {
        //Arrange
        StudentDTO stu=new StudentDTO();
        stu.setId(-1L);
        stu.setStudentName("David");
        stu.setSubjects(subjectDTOList);
        stu.setAverageScore(9.0);
        when(studentDAO.findById(anyLong())).thenReturn(stu);
        //Act
        StudentDTO response=studentService.read(-1L);

        //Assert
        verify(studentDAO,atLeast(1)).findById(-1L);
        Assertions.assertEquals(stu,response);
    }

    @Test
    void update() {
        //Arrange
        StudentDTO stu=new StudentDTO();
        //Act
        studentService.update(stu);

        //Assert
        verify(studentDAO,atLeast(1)).save(stu);
    }

    @Test
    void delete() {
        //Arrange
        Long id=1L;
        //Act
        studentService.delete(id);

        //Assert
        verify(studentDAO,atLeast(1)).delete(id);
    }

    @Test
    void getAllOk() {
        //Arrange
        Set<StudentDTO> allStudents=new HashSet<>();
        allStudents.add(new StudentDTO(1L,"David",subjectDTOList));
        allStudents.add(new StudentDTO(2L,"Pepito",subjectDTOList));

        when(studentRepository.findAll()).thenReturn(allStudents);

        //Act
        Set<StudentDTO> response=studentService.getAll();
        //Assert
        verify(studentRepository, atLeast(1)).findAll();
        Assertions.assertEquals(allStudents,response);
    }
}