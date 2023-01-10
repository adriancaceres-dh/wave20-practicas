package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDAOTest {

  @Test
  public void agregarEstudiante() {
    IStudentDAO studentDAO = new StudentDAO();
    studentDAO.delete(10L);
    List<SubjectDTO> subjects = List.of(
      new SubjectDTO("Matematica", 10.0),
      new SubjectDTO("Fisica", 10.0),
      new SubjectDTO("Quimica", 10.0)
    );
    StudentDTO studentDTO = new StudentDTO(10L, "Juan", "", 0.0, subjects);
    studentDAO.save(studentDTO);
    assertTrue(studentDAO.exists(studentDTO));
  }

  @Test
  public void buscarPorIDok() {
    IStudentDAO studentDAO = new StudentDAO();
    assertTrue(studentDAO.findById(1L) != null);
  }

  @Test
  public void buscarPorIDbad() {
    IStudentDAO studentDAO = new StudentDAO();
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));
  }

  @Test
  public void eliminarEstudiante() {
    IStudentDAO studentDAO = new StudentDAO();
    studentDAO.delete(11L);
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(11L));
  }


}
