package com.meli.obtenerdiploma.repo;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

  IStudentDAO studentDAO = new StudentDAO();
  IStudentRepository studentRepository = new StudentRepository();


  SubjectDTO kahoot;
  SubjectDTO musica;
  SubjectDTO poo;

  StudentDTO student;

  @BeforeEach
  public void beforeEach() {
    kahoot = new SubjectDTO("Kahoot", 1.0);
    musica = new SubjectDTO("Musica", 9.0);
    poo =    new SubjectDTO("POO",    2.0);

    student =new StudentDTO(11L, "Anibal","El alumno Anibal ha obtenido un promedio de 4. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

    if( ! studentDAO.exists( student ) ) studentDAO.save( student );

  }

  @Test
  void agregarEstudiante() {
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
  void buscarPorIDok() {
    assertNotNull(studentDAO.findById(11L));
  }

  @Test
  void buscarPorIDbad() {
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));
  }

  @Test
  void eliminarEstudiante() {
    studentDAO.delete(10L);
    List<SubjectDTO> subjects = List.of(
            new SubjectDTO("Matematica", 10.0),
            new SubjectDTO("Fisica", 10.0),
            new SubjectDTO("Quimica", 10.0)
    );
    StudentDTO studentDTO = new StudentDTO(10L, "Juan", "", 0.0, subjects);
    studentDAO.save(studentDTO);
    assertTrue(studentDAO.exists(studentDTO));
    boolean flag = studentDAO.delete(10L);
    assertTrue(flag);
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(10L));
  }

  @Test
  void listarTodos() {
    Set<StudentDTO> lista = studentRepository.findAll();
    assertTrue(lista.size() > 0);
  }

  @Test
  void listarTodosFileNotFound() {
    studentRepository = new StudentRepository("");
    Set<StudentDTO> lista = studentRepository.findAll();
    assertEquals(0, lista.size());
  }

}
