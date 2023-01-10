package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.meli.obtenerdiploma.repository.StudentDTOUtil.createStudentWithSubject;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    private IStudentDAO studentDAO;

    @Autowired
    public StudentDAOTest(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Test
    void saveNewSubject() {
        StudentDTO studentDTO = createStudentWithSubject();
        Long firstId = 1L;

        studentDAO.save(studentDTO);

        assertDoesNotThrow(() -> studentDAO.findById(firstId));

        studentDAO.delete(studentDTO.getId());
    }

    @Test
    void saveOverwriteStudent() {
        Long studentId = 1L;
        StudentDTO studentDTO = createStudentWithSubject();
        studentDTO.setId(studentId);

        studentDAO.save(studentDTO);
        String newName = "John Doe";
        studentDTO.setStudentName(newName);

        studentDAO.save(studentDTO);

        StudentDTO studentWithExpecteNewName = studentDAO.findById(studentId);

        assertEquals(newName, studentWithExpecteNewName.getStudentName());

        studentDAO.delete(studentId);
    }

    @Test
    void saveFailsWhenNullStudent() {
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    void deleteReturnsFalseWhenStudentDoesNotExist() {
        assertFalse(studentDAO.delete(1L));
    }

    @Test
    void deleteReturnsTrueWhenStudentExists() {
        StudentDTO studentDTO = createStudentWithSubject();
        Long studentId = 1L;
        studentDTO.setId(studentId);
        studentDAO.save(studentDTO);

        assertTrue(studentDAO.delete(studentId));
    }

    @Test
    void existsReturnsTrueWhenStudentExists() {
        StudentDTO studentDTO = createStudentWithSubject();
        Long studentId = 1L;
        studentDTO.setId(studentId);
        studentDAO.save(studentDTO);

        assertTrue(studentDAO.exists(studentDTO));

        studentDAO.delete(studentId);
    }

    @Test
    void existsReturnsFalseWhenStudentDoesNotExists() {
        StudentDTO studentDTO = createStudentWithSubject();

        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    void findByIdReturnsStudentWhenItExists() {
        StudentDTO studentDTO = createStudentWithSubject();
        Long studentId = 1L;
        studentDTO.setId(studentId);

        studentDAO.save(studentDTO);

        assertEquals(studentDTO, studentDAO.findById(studentId));

        studentDAO.delete(studentId);
    }

    @Test
    void findByIdThrowsWhenIdNotFound() {
        Long studentId = 1L;


        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentId));

    }
}