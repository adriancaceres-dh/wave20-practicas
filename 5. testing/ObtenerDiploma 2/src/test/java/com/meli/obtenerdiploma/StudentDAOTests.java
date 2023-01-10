package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.parameter_resolver.StudentDAOParameterResolver;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(StudentDAOParameterResolver.class)
public class StudentDAOTests {

    IStudentDAO studentDAO;

    public StudentDAOTests(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Test
    void saveOk() {
        // arrange
        StudentDTO student = new StudentDTO(3L, "Óscar", null, null, List.of(new SubjectDTO("Matemática", 6D), new SubjectDTO("Física", 9D)));
        // act
        studentDAO.save(student);
        // assert
        assertNotNull(student.getId());
    }

    @Test
    void deleteOk() {
        // arrange
        Long id = 2L;
        // act
        boolean deleted = studentDAO.delete(id);
        // assert
        assertTrue(deleted);
    }

    @Test
    void deleteFalse() {
        // arrange
        Long id = 30L;
        // act
        boolean deleted = studentDAO.delete(id);
        // assert
        assertFalse(deleted);
    }

    @Test
    void existsTrue() {
        // arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        // act
        boolean exists = studentDAO.exists(student);
        // assert
        assertTrue(exists);
    }

    @Test
    void existsFalse() {
        // arrange
        StudentDTO student = new StudentDTO();
        // act
        boolean exists = studentDAO.exists(student);
        // assert
        assertFalse(exists);
    }

    @Test
    void findByIdOk() {
        // arrange
        Long id = 1L;
        // act
        StudentDTO student = studentDAO.findById(id);
        // assert
        assertNotNull(student);
    }

    @Test
    void findByIdException() {
        // arrange
        Long id = 20L;
        // act
        Executable executable = () -> studentDAO.findById(id);
        // assert
        assertThrows(StudentNotFoundException.class, executable);
    }
}
