package com.meli.obtenerdiploma.testUnitarios.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTestWithMocks {

    @Mock
    IStudentDAO mockStudentDAO;
    @Mock
    IStudentRepository mockStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Creando estudiante y guardandolo en el repo")
    void createOK(){

        //Arrange
        StudentDTO studentDTOTest = new StudentDTO(3L, "Arturo", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));

        //Act
        studentService.create(studentDTOTest);
        //Assert
        verify(mockStudentDAO,atLeastOnce()).save(studentDTOTest);

    }
    @Test
    @DisplayName(" Retornando estudiante por su id")
    void readOK(){

        //Arrange
        StudentDTO expectedStudentDTO = new StudentDTO(2L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        when(mockStudentDAO.findById(expectedStudentDTO.getId())).thenReturn(expectedStudentDTO);

        //Act
        StudentDTO actualStudentDTO=studentService.read(expectedStudentDTO.getId());
        //Assert
        Assertions.assertEquals(expectedStudentDTO,actualStudentDTO);
        verify(mockStudentDAO,atLeastOnce()).findById(expectedStudentDTO.getId());

    }

    @Test
    @DisplayName("Actualizando estudiante ya existente")
    void updateOK(){
        //Arrange
        StudentDTO studentDTOTest = new StudentDTO(3L, "Arturo", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));

        //Act
        studentService.update(studentDTOTest);
        //Assert
        verify(mockStudentDAO,atLeastOnce()).save(studentDTOTest);

    }

    @Test
    @DisplayName("Eliminando un estudiante por su ID")
    void deleteOK(){
        //Arrange
        Long id = 1L;
        //Act
        studentService.delete(id);
        //Assert
        verify(mockStudentDAO,atLeastOnce()).delete(id);
    }

    @Test
    @DisplayName("Obtener todos los estudiantes")
    void shouldGetAllOK(){
        //Arrange
        StudentDTO studentDTOTest1 = new StudentDTO(2L, "Diego", null, null, List.of(
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Calculo", 7.0),
                new SubjectDTO("Diseño", 6.0)));
        StudentDTO studentDTOTest2 = new StudentDTO(2L, "Juan", null, null, List.of(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)));
        Set<StudentDTO> expectedSet = new HashSet<>();
        expectedSet.add(studentDTOTest1);
        expectedSet.add(studentDTOTest2);
        when(mockStudentRepository.findAll()).thenReturn(expectedSet);
        //Act
        Set<StudentDTO> actualSetResponse = studentService.getAll();
        //Assert
        Assertions.assertEquals(expectedSet,actualSetResponse);

    }



}
