package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testCreate(){
        //Arrange
        Long queryId = 5L;
        List<SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO stu = new StudentDTO(5L,"Camilo","Buen estudiante"
                , 4.0, subjectsDTOS );
        when(studentDAO.findById(queryId)).thenReturn(stu);
        //Action
        StudentDTO foundStudent = studentService.read(queryId);

        //Assert
        assertNotNull(foundStudent);
        assertEquals(stu.getStudentName(),foundStudent.getStudentName());
    }

    @Test
    void testGetAll(){
        //Arrange
        List<SubjectDTO> subjectsDTOS = new ArrayList<>();
        subjectsDTOS.add(new SubjectDTO("Maths",4.0) );
        subjectsDTOS.add(new SubjectDTO("History",4.5) );
        StudentDTO student1 = new StudentDTO(5L,"Camilo","Buen estudiante"
                , 10.0, subjectsDTOS );
        StudentDTO student2 = new StudentDTO(6L,"Andres","mal estudiante"
                , 4.0, subjectsDTOS );
        Set<StudentDTO> studentDTOSet = Set.of(student1, student2);
        when(studentRepository.findAll()).thenReturn(studentDTOSet);

        //Action
        Set<StudentDTO> studentSet = studentService.getAll();

        //Assert
        assertEquals(2,studentSet.size());
        assertTrue(studentSet.stream().anyMatch(s -> s.getStudentName().equals("Andres")));
    }

}