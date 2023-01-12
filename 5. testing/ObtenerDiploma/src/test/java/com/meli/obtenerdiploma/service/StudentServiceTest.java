package com.meli.obtenerdiploma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Caso feliz - Debería poder registrar un estudiante nuevo")
    public void createStudent() {
        //Arrange
        StudentDTO student = new StudentDTO(3L, "Mario", List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 6.0),
                new SubjectDTO("Química", 8.0)));

        //Act
        studentService.create(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);

    }

    @Test
    @DisplayName("Caso feliz - Debería retornar el estudiante solicitado ingresando el Id")
    public void findStudentById() {
        //Arrange
        long idTest = 2L;
        StudentDTO studentExpected =
                new StudentDTO(2L, "Pedro", List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)));

        when(studentDAO.findById(idTest)).thenReturn(studentExpected);

        //Act
        StudentDTO actualStudent = studentService.read(idTest);

        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentExpected.getId());
        assertEquals(studentExpected, actualStudent);

    }

    @Test
    @DisplayName("Caso feliz - Debería poder modificar el usuario ingresado")
    public void updateStudent() {
        //Arrange
        StudentDTO student =
                new StudentDTO(2L, "Pedro", List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)));

        //Act
        studentService.update(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);

    }

    @Test
    @DisplayName("Caso feliz - Debería eliminar un estudiante por el id ingresado")
    void deleteStudent() {
        //Arrange
        Long idTest = 1L;

        //Act
        studentService.delete(idTest);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(idTest);

    }

    @Test
    @DisplayName("Caso feliz - Debería retornar la lista completa de estudiantes registrados")
    void getAll() {
        //Arrange
        String json = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 9\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 6\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"studentName\": \"Pedro\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 8\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        ObjectMapper mapper = new ObjectMapper();
        Set<StudentDTO> students;

        //No creo que esta sea la mejor opción ya que son demasiados pasos, pero fue lo que se me ocurrió

        try {
            students = mapper.readValue(json, new TypeReference<Set<StudentDTO>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        when(studentRepository.findAll()).thenReturn(students);

        //Act
        Set<StudentDTO> actual = studentService.getAll();

        //Assert
        assertEquals(students, actual);
        assertEquals(students.size(), actual.size());

    }
}