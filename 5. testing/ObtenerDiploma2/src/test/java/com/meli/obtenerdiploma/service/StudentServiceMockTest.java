package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceMockTest {
  @Mock
  StudentDAO studentDAOmock;

  @Mock
  StudentRepository studentRepositoryMock;

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
    doNothing().when(studentDAOmock).save(any(StudentDTO.class));

    //act
    studentService.create(studentDTO);

    //assert
    verify(studentDAOmock, times(1)).save(any(StudentDTO.class));
  }

  @Test
  void testReadOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    when(studentDAOmock.findById(any(Long.class))).thenReturn(studentDTO);

    //act
    StudentDTO studentDTORead = studentService.read(1L);

    //verify
    assertEquals(studentDTO, studentDTORead);
  }

  @Test
  void testReadStudentNotFound() {
    //arrange
    when(studentDAOmock.findById(1L)).thenThrow(new StudentNotFoundException(1L));

    //ASSERT
    assertThrows(StudentNotFoundException.class, () -> studentService.read(1L));
    verify(studentDAOmock, times(1)).findById(1L);
  }

  @Test
  void testUpdateOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    doNothing().when(studentDAOmock).save(any(StudentDTO.class));

    //act
    studentService.update(studentDTO);

    //assert
    verify(studentDAOmock, times(1)).save(any(StudentDTO.class));
  }

  @Test
  void testDeleteOk() {
    //arrange
    when(studentDAOmock.delete(any(Long.class))).thenReturn(true);

    //act
    studentService.delete(1L);

    //assert
    verify(studentDAOmock, times(1)).delete(any(Long.class));
  }

  @Test
  void testGetAllOk() {
    //arrange

    Set<StudentDTO> studentDTOSet = Set.of(
            new StudentDTO(1L, "Juan", "", 0.0, null),
            new StudentDTO(2L, "Pedro", "", 0.0, null),
            new StudentDTO(3L, "Maria", "", 0.0, null)
    );
    when(studentRepositoryMock.findAll()).thenReturn(studentDTOSet);

    //act
    Set<StudentDTO> studentDTOS = studentService.getAll();

    //assert
    assertEquals(studentDTOSet, studentDTOS);
    verify(studentRepositoryMock, times(1)).findAll();
  }

}
