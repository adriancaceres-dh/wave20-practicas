package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
  @Mock
  StudentService studentServiceMock;

  @InjectMocks
  StudentController studentController;

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
  void testRegisterStudentOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    doNothing().when(studentServiceMock).create(studentDTO);

    //act
    ResponseEntity<?> response = studentController.registerStudent(studentDTO);

    //assert
    assertTrue(response.getStatusCode().is2xxSuccessful());
    verify(studentServiceMock, times(1)).create(studentDTO);
  }

  @Test
  void testGetStudentOk() {
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, null);
    when(studentServiceMock.read(1L)).thenReturn(studentDTO);

    //act
    StudentDTO studentResponse = studentController.getStudent(1L);

    //assert
    assertEquals(studentDTO, studentResponse);
    verify(studentServiceMock, times(1)).read(1L);
  }

  @Test
  void testGetStudentbad() {
    //arrange
    ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "El alumno con Id 1 no se encuentra registrado");
    ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    when(studentServiceMock.read(1L)).thenThrow(StudentNotFoundException.class);
    //act

    //assert
    assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(1L));
    verify(studentServiceMock, times(1)).read(1L);
  }

}
