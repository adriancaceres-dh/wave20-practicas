package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudenDAOTest {

    private StudentDAO studentDAO;
    private StudentDTO student;

    public StudenDAOTest() {
        this.studentDAO = new StudentDAO();
    }


    @BeforeEach
    public void init() {
        long id = 2L;
        List<SubjectDTO> subjects = Arrays.asList(
                SubjectDTO
                        .builder()
                        .name("Matemática")
                        .score(10.0)
                        .build(),
                SubjectDTO
                        .builder()
                        .name("Fisíca")
                        .score(8.0)
                        .build(),
                SubjectDTO
                        .builder()
                        .name("Química")
                        .score(4.0)
                        .build()
        );
        this.student = StudentDTO
                .builder()
                .studentName("Pedro")
                .id(id)
                .subjects(subjects)
                .build();
    }

    @Test
    public void shouldExistsTest() {
        //arrange
        StudentDTO expected = this.student;
        //act
        boolean actual = studentDAO.exists(expected);
        //assert
        assertTrue(actual);
    }

    @Test
    public void shouldNotExistsTest() {
        //arrange
        Long id = 100L;
        StudentDTO expected = StudentDTO
                .builder()
                .id(id).build();
        //act
        boolean actual = studentDAO.exists(expected);
        //assert
        assertFalse(actual);
    }

    @Test
    @Disabled
    public void shouldDeleteTest() {
        //arrange
        long id = this.student.getId();
        //act
        boolean actual = studentDAO.delete(id);
        //assert
        assertTrue(actual);
    }

    @Test
    public void shouldNotDeleteTest() {
        //arrange
        long id = 100L;
        boolean expected = false;
        //act
        boolean actual = studentDAO.delete(id);
        //assert
        assertFalse(expected);
    }

    @Test
    public void shoulFindById() {
        //arrange
        StudentDTO expected = this.student;
        //act
        StudentDTO actual = studentDAO.findById(this.student.getId());
        //assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getStudentName(), actual.getStudentName());
        assertEquals(expected.getSubjects().size(), actual.getSubjects().size());
    }
}
