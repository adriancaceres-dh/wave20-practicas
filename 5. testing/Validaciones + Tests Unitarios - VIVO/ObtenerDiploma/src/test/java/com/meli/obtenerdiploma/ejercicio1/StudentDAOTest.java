package com.meli.obtenerdiploma.ejercicio1;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

public class StudentDAOTest {

    private IStudentDAO studentDAO;

    public StudentDAOTest() {
        studentDAO = new StudentDAO();
    }

    @Test
    void findByIdOk() {
        //arrange
        long studentId = 2L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO expected = util.getStudent(studentId, "Ramón", subjects);
        studentDAO.save(expected);

        //act
        StudentDTO actual = studentDAO.findById(studentId);

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByIdThrow() {
        //arrange
        long studentId = 598L;

        //act y assert
        Assertions.assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(studentId));
    }

    @Test
    void existsOk() {
        //arrange
        long studentId = 3L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO expected = util.getStudent(studentId, "Mario", subjects);
        studentDAO.save(expected);

        //act
        boolean actual = studentDAO.exists(expected);

        //assert
        Assertions.assertTrue(actual);
    }

    @Test
    void deleteOk() {
        //arrange
        long studentId = 4L;
        List<SubjectDTO> subjects = util.getSubjects(false);
        StudentDTO expected = util.getStudent(studentId, "Ana", subjects);
        studentDAO.save(expected);

        //act
        boolean actual = studentDAO.delete(studentId);

        //assert
        Assertions.assertTrue(actual);
    }
}
