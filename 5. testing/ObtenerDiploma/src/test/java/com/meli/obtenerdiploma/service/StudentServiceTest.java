package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentServiceTest {
    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDTOTest1 = new StudentDTO(0L, "Martin", "", 6.8, List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Física", 9.0)));
    private StudentDTO studentDTOTest3DeUserJuan = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)));
    private StudentDTO studentDTOTest3DeUserPedro = new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0)));

    @BeforeEach
    public void loadData() {
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(2L);
        studentDTO1.setStudentName("Pedro");
        studentDTO1.setSubjects(new ArrayList<>(Arrays.asList(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0))));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(1L);
        studentDTO2.setStudentName("Juan");
        studentDTO2.setSubjects(new ArrayList<>(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))));
    }

    @Test
    void create() {
        //Arrange
        StudentDTO studentMartin = studentDTOTest1;
        // act
        studentService.create(studentMartin);

        // assert
        verify(studentDAO, atLeastOnce()).save(studentMartin);
    }

    @Test
    public void readTest() {

        //Arrange
        StudentDTO expectedstudentDTO = new StudentDTO();
        expectedstudentDTO.setId(1L);
        expectedstudentDTO.setStudentName("Pedro");
        expectedstudentDTO.setSubjects(new ArrayList<>(Arrays.asList(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0))));
        studentDAO.save(expectedstudentDTO);


        StudentDTO actualStudentDto;

        //Act
        when(studentDAO.findById(1L)).thenReturn(expectedstudentDTO);
        actualStudentDto = studentService.read(1L);

        //Assert
        Assertions.assertEquals(expectedstudentDTO, actualStudentDto);

    }

    @Test
    void update() {
        //Arrange
        StudentDTO studentMartin = studentDTOTest1;
        // act
        studentService.update(studentMartin);

        // assert
        verify(studentDAO, atLeastOnce()).save(studentMartin);
    }

    @Test
    void delete(){
        //Arrange
        StudentDTO studentMartin = studentDTOTest1;
        // act
        studentService.delete(studentMartin.getId());

        // assert
        verify(studentDAO, atLeastOnce()).delete(studentMartin.getId());
    }

    @Test
    public void getAll() {

        // Arrange
        Set<StudentDTO> loadedDataExpected = new HashSet<>();
        loadedDataExpected.addAll(Set.of(new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0))),
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)))));
        when(studentRepository.findAll()).thenReturn(loadedDataExpected);
        // Act
        Set<StudentDTO> loadedDataResult = studentService.getAll();
        // Assert);
        assertTrue(loadedDataExpected.size() == loadedDataResult.size());
        assertEquals(loadedDataExpected, loadedDataResult);
    }
}

