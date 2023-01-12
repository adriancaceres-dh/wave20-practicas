package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.meli.obtenerdiploma.util.StudentDTOUtil.createStudentWithSubject;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    private IStudentDAO studentDAO;

    @Autowired
    public StudentDAOTest(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Test
    void saveNewStudent() {
        StudentDTO studentDTO = createStudentWithSubject();

        studentDAO.save(studentDTO);

        assertDoesNotThrow(() -> studentDAO.findById(studentDTO.getId()));

        studentDAO.delete(studentDTO.getId());
    }

    @Test
    void saveOverwriteStudent() {
        StudentDTO studentDTO = createStudentWithSubject();
        studentDTO.setStudentName("Johny Doe");

        studentDAO.save(studentDTO);
        String newName = "John Doe";
        studentDTO.setStudentName(newName);

        studentDAO.save(studentDTO);

        StudentDTO studentWithExpectedNewName = studentDAO.findById(studentDTO.getId());

        assertEquals(newName, studentWithExpectedNewName.getStudentName());

        studentDAO.delete(studentDTO.getId());
    }

    @Test
    void saveFailsWhenNullStudent() {
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    void deleteReturnsFalseWhenStudentDoesNotExist() {
        assertFalse(studentDAO.delete(200000L));
    }

    @Test
    void deleteReturnsTrueWhenStudentExists() {
        StudentDTO studentDTO = createStudentWithSubject();
        studentDAO.save(studentDTO);

        assertTrue(studentDAO.delete(studentDTO.getId()));
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

        studentDAO.save(studentDTO);

        assertEquals(studentDTO, studentDAO.findById(studentDTO.getId()));

        studentDAO.delete(studentDTO.getId());
    }

    @Test
    void findByIdThrowsWhenIdNotFound() {
        Long studentId = 20000L;


        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentId));

    }
}