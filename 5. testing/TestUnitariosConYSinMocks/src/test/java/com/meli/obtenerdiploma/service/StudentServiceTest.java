package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest(){
        SubjectDTO subjectTest1 = new SubjectDTO("Math",10.0);
        SubjectDTO subjectTest2 = new SubjectDTO("Art",9.0);
        SubjectDTO subjectTest3 = new SubjectDTO("Sports",8.0);
        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
        StudentDTO student = new StudentDTO(1L,"nombreEst", "message",1.2,subjectList);

        studentService.create(student);
        verify(studentDAO,atLeast(1)).save(student);


    }
//    @Test
//    public void readTest(){
//        Long studentId = 1L;
//        SubjectDTO subjectTest1 = new SubjectDTO("Math",10.0);
//        SubjectDTO subjectTest2 = new SubjectDTO("Art",9.0);
//        SubjectDTO subjectTest3 = new SubjectDTO("Sports",8.0);
//        List<SubjectDTO> subjectList = Arrays.asList(subjectTest1,subjectTest2,subjectTest3);
//        StudentDTO student = new StudentDTO(1L,"nombreEst", "message",1.2,subjectList);
//        student.setAverageScore(9.0);
//        student.setMessage("El alumno " + "nombreEst" + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(9.0)
//                + ". Puedes mejorar.");
//
//
//        when(studentDAO.findById(studentId)).thenReturn(student);
//
//        StudentDTO resp = studentDAO.findById(studentId);
//
//        Assertions.assertEquals(student,resp);
//    }
}
