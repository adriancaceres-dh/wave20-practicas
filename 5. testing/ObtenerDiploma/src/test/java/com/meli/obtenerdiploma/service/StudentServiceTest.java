package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.*;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAOMock;
    @Mock
    IStudentRepository studentRepositoryMock;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest(){

        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);

        StudentDTO student = new StudentDTO(4L,"Ignacio","",9.0,subjects);

        studentService.create(student);

        verify(studentDAOMock, times(1)).save(student);

    }

    @Test
    public void readTest(){
        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);

        StudentDTO student = new StudentDTO(4L,"Ignacio","",9.0,subjects);

        when(studentDAOMock.findById(any())).thenReturn(student);

        StudentDTO output = studentService.read(4L);
        assertEquals(student.getStudentName(),output.getStudentName());
    }

    @Test
    public void verifyTest(){

        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);

        StudentDTO student = new StudentDTO(4L,"Ignacio","",9.0,subjects);

        studentService.update(student);

        verify(studentDAOMock, times(1)).save(student);

    }

    @Test
    public void deleteTest(){

        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);

        StudentDTO student = new StudentDTO(4L,"Ignacio","",9.0,subjects);

        studentService.delete(4L);

        verify(studentDAOMock, times(1)).delete(4L);

    }

    @Test
    public void getAllTest(){

        SubjectDTO sub1 = new SubjectDTO("Matematica",9.10);
        SubjectDTO sub2 = new SubjectDTO("Historia",9.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);

        StudentDTO student = new StudentDTO(4L,"Ignacio","",9.0,subjects);
        StudentDTO student2 = new StudentDTO(4L,"Agustin","",9.0,subjects);

        Set<StudentDTO> students= Set.of(student,student2);

        when(studentRepositoryMock.findAll()).thenReturn(students);


        Set<StudentDTO> output = studentService.getAll();

        assertEquals(students,output);

    }


}
