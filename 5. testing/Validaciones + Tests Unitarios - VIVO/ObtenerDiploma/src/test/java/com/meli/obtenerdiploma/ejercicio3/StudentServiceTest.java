package com.meli.obtenerdiploma.ejercicio3;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.util;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;


    @InjectMocks
    private StudentService studentService;

//    @BeforeEach
//    private void setUp() {
//        util.emptyFile();
//    }

    @Test
    void readOk(){
        //arrange
        long studentId = 1L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO studentDTO = util.getStudent(studentId, "Alejandro",subjects);
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        //act
        StudentDTO actual = studentService.read(studentId);

        //assert
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(studentDTO, actual);

    }

    @Test
    void CreateOk(){
        //arrange
        long studentId = 1L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO studentDTO = util.getStudent(studentId, "Alejandro",subjects);

        //act
        studentService.create(studentDTO);

        //assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void updateOk(){
        //arrange
        long studentId = 1L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO studentDTO = util.getStudent(studentId, "Alejandro",subjects);

        //act
        studentService.update(studentDTO);

        //assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void deleteOk(){
        //arrange
        long studentId = 1L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO studentDTO = util.getStudent(studentId, "Alejandro",subjects);
        studentDAO.save(studentDTO);

        //act
        studentService.delete(studentId);

        //assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

    @Test
    void getAllOk(){
        Set<StudentDTO> expectedStudent = new HashSet<>();

        List<SubjectDTO> subjects1 = util.getSubjects(false);
        StudentDTO studentDTO1 = util.getStudent(1L, "María", subjects1);
        expectedStudent.add(studentDTO1);
        studentDAO.save(studentDTO1);

        List<SubjectDTO> subjects2 = util.getSubjects(false);
        StudentDTO studentDTO2 = util.getStudent(2L, "René", subjects2);
        expectedStudent.add(studentDTO2);
        studentDAO.save(studentDTO2);

        List<SubjectDTO> subjects3 = util.getSubjects(false);
        StudentDTO studentDTO3 = util.getStudent(3L, "Tomas", subjects3);
        expectedStudent.add(studentDTO3);
        studentDAO.save(studentDTO3);
        when(studentRepository.findAll()).thenReturn(expectedStudent);

        //act
        Set<StudentDTO> studentsActual = studentService.getAll();

        //assert
        Assertions.assertEquals(expectedStudent.size(),studentsActual.size());
        Assertions.assertTrue(CollectionUtils.isEqualCollection(studentsActual, expectedStudent));
    }
}
