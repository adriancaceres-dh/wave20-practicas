package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    assertTrue(respuesta.getAverageScore() == 9);
    assertTrue(respuesta.getMessage().equals("Felicitaciones Juan, tu promedio es 9.0"));

  }

}
