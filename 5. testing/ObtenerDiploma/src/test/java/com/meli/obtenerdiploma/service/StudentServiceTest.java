package com.meli.obtenerdiploma.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;


@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    //Object DTO
    StudentDTO studentDTO;

    public StudentServiceTest() {
        this.studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
    }

    @Test
    @DisplayName("US-001 Create Camino Feliz...")
    void createTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("US-002 Read Camino Feliz...")
    void readTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        when(studentDAO.findById(studentId)).thenReturn(expectedStudentDTO);
        //Act
        StudentDTO actualStudentDTO = studentService.read(studentId);
        //Assert
        Assertions.assertEquals(expectedStudentDTO, actualStudentDTO);
    }

    @Test
    @DisplayName("US-003 Update Camino Feliz...")
    void updateTest() {
        //Arrange

        //Act
        studentService.update(studentDTO);
        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);

    }

    @Test
    @DisplayName("US-004 Delete Camino Feliz...")
    void deleteTest() {
        //Arrange


        //Act
        studentService.delete(studentDTO.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    @DisplayName("US-005 getAll Camino Feliz...")
    void getAllTest() {
        //Arrange
        Set<StudentDTO> expectedStudentsSet = new HashSet<>();
        StudentDTO studentDTO1 = new StudentDTO(1L, "Juan", List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        expectedStudentsSet.add(studentDTO1);

        StudentDTO studentDTO2 = new StudentDTO(2L, "Pedro", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)));
        expectedStudentsSet.add(studentDTO2);
        when(studentRepository.findAll()).thenReturn(expectedStudentsSet);
        //Act
        Set<StudentDTO> actualStudentsSet = studentService.getAll();

        //Assert
        Assertions.assertEquals(expectedStudentsSet, actualStudentsSet);
        Assertions.assertEquals(expectedStudentsSet.size(), actualStudentsSet.size());
    }

}
