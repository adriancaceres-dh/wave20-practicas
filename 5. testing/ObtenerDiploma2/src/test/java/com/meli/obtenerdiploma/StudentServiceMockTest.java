package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentServiceMockTest {
  @Mock
  StudentDAO studentDAO;

  @Mock
  StudentRepository studentRepository;

  @InjectMocks
  StudentService studentService;

  private AutoCloseable closeable;

  @BeforeEach
  void openMocks() {
    closeable = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void releaseMocks() throws Exception {
    closeable.close();
  }

  @Test
  void testCreateOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    doNothing().when(studentDAO).save(any(StudentDTO.class));

    //act
    studentService.create(studentDTO);

    //assert
    verify(studentDAO, times(1)).save(any(StudentDTO.class));
  }

  @Test
  void testReadOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

    //act
    StudentDTO studentDTORead = studentService.read(1L);

    //verify
    assertEquals(studentDTO, studentDTORead);
  }

  @Test
  void testUpdateOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    doNothing().when(studentDAO).save(any(StudentDTO.class));

    //act
    studentService.update(studentDTO);

    //assert
    verify(studentDAO, times(1)).save(any(StudentDTO.class));
  }

  @Test
  void testDeleteOk() {
    //arrange
    when(studentDAO.delete(any(Long.class))).thenReturn(true);

    //act
    studentService.delete(1L);

    //assert
    verify(studentDAO, times(1)).delete(any(Long.class));
  }

  @Test
  void testGetAllOk() {
    //arrange

    Set<StudentDTO> studentDTOSet = Set.of(
            new StudentDTO(1L, "Juan", "", 0.0, null),
            new StudentDTO(2L, "Pedro", "", 0.0, null),
            new StudentDTO(3L, "Maria", "", 0.0, null)
    );
    when(studentRepository.findAll()).thenReturn(studentDTOSet);

    //act
    Set<StudentDTO> studentDTOS = studentService.getAll();

    //assert
    assertEquals(studentDTOSet, studentDTOS);
  }

}
