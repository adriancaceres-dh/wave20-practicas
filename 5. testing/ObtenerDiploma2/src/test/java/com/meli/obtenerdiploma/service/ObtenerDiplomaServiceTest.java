package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
  @Mock
  StudentDAO studentDAO;

  @InjectMocks
  ObtenerDiplomaService obtenerDiplomaService;

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
  void testAnalizeScoresOk() {
    List<SubjectDTO> subjectDTOList = List.of(
            new SubjectDTO("Matematica", 10.0),
            new SubjectDTO("Lengua", 9.0),
            new SubjectDTO("Historia", 8.0)
    );
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, subjectDTOList);
    when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

    //act
    StudentDTO respuesta = obtenerDiplomaService.analyzeScores(1L);

    //assert
    assertEquals(9, (double) respuesta.getAverageScore());
    assertEquals("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.", respuesta.getMessage());

  }

  @Test
  void testAnalizeScoresHonoresOk() {
    List<SubjectDTO> subjectDTOList = List.of(
            new SubjectDTO("Matematica", 10.0),
            new SubjectDTO("Lengua", 9.0),
            new SubjectDTO("Historia", 10.0)
    );
    //arrange
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, subjectDTOList);
    when(studentDAO.findById(any(Long.class))).thenReturn(studentDTO);

    //act
    StudentDTO respuesta = obtenerDiplomaService.analyzeScores(1L);

    //assert
    assertEquals("9.67", new DecimalFormat("#.##").format(respuesta.getAverageScore()));
    assertEquals("El alumno Juan ha obtenido un promedio de 9.67. Felicitaciones!", respuesta.getMessage());

  }

}
