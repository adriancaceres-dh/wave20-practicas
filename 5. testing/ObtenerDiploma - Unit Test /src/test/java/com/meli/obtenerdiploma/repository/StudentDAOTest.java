package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    private final IStudentDAO studentDAO;

    public StudentDAOTest () {
        this.studentDAO = new StudentDAO();
    }
    static StudentDTO createStudentDTO(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 8.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("Hola");
        studentDTO.setSubjects(subjectDTOList);
        return studentDTO;
    }

    @Test
    void saveOk() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        //act
        studentDAO.save(studentDTO);
        StudentDTO studentExpected = studentDAO.findById(studentDTO.getId());
        //assert
        assertEquals(studentExpected.getStudentName(), studentDTO.getStudentName());
    }

    @Test
    void deleteOk() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        studentDAO.save(studentDTO);
        //act
        boolean res = studentDAO.delete(studentDTO.getId());
        //assert
        Assertions.assertTrue(res);
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    void deleteStudentNotFoundExceptionTest() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        //act
        studentDAO.delete(studentDTO.getId());
        //assert
        Assertions.assertFalse(studentDAO.exists(studentDTO));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    void existsOk() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        //act
        studentDAO.save(studentDTO);
        //assert
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void existStudentNotFoundExceptionTest() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        //act
        boolean res = studentDAO.exists(studentDTO);
        //assert
        assertFalse(res);
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    void findByIdOk() {
        //arrange
        StudentDTO studentDTO = createStudentDTO();
        studentDAO.save(studentDTO);
        //act
        StudentDTO studentActual = studentDAO.findById(studentDTO.getId());
        //assert
        assertEquals(studentActual, studentDTO);
    }

    @Test
    void findByIdStudentNotFoundException() {
        //arrange
        Long id = 3L;
        //act - assert
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(id));
    }
}