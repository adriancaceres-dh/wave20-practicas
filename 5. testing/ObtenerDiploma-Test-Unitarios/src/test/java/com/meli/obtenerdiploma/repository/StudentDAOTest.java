package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void saveTestOk(){

        //Arrage
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 7.0));
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);

        //Act
        studentDAO.save(studentDTO);

        //Assert
        assertTrue(studentDAO.exists(studentDTO));

    }

    @Test
    public void editTestOk(){

        //Arrage
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 7.0));
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);
        studentDAO.save(studentDTO);
        studentDTO.setId(studentDAO.getStudents().size() + 0L);
        studentDTO.setStudentName("nombreEditado");

        List<SubjectDTO> subjectDTOList2 = new ArrayList<>();
        subjectDTOList2.add(new SubjectDTO("Matematica", 7.0));
        Long id = studentDAO.getStudents().size() + 0L;
        StudentDTO expected = new StudentDTO(id, "nombreEditado", null, null, subjectDTOList2);

        //Act
        studentDAO.save(studentDTO);
        StudentDTO student = studentDAO.findById(id);
        //Assert
        assertEquals(expected, student);

    }

    @Test
    public void deleteTestOk(){

        //Arrage
        SubjectDTO subjectDTO1 = new SubjectDTO("Ciencias", 8.0);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);

        //Act
        studentDAO.save(studentDTO);
        boolean ret = studentDAO.delete(studentDAO.getStudents().size() + 0L);

        //Assert
        assertTrue(ret);
        assertFalse(studentDAO.exists(studentDTO));

    }

    @Test
    public void deleteTestInvalidId(){

        //Arrage
        Long id = studentDAO.getStudents().size() + 1L;
        //Act
        boolean ret = studentDAO.delete(id);

        //Assert
        assertFalse(ret);

    }

    @Test
    public void existTestOk(){

        //Arrage
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 7.0));
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);
        studentDAO.save(studentDTO);

        //Act
        boolean ret = studentDAO.exists(studentDTO);

        //Assert
        assertTrue(ret);

    }

    @Test
    public void existTestInvalidStudent(){

        //Arrage
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematica", 7.0);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);

        //Act
        boolean ret = studentDAO.exists(studentDTO);

        //Assert
        assertFalse(ret);

    }

    @Test
    public void findByIdTestOk(){

        //Arrage
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematica", 7.0);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectDTO1);
        StudentDTO studentDTO = new StudentDTO(null, "nombre", null, null, subjectDTOList);
        studentDAO.save(studentDTO);
        Long id = studentDAO.getStudents().size() + 0L;
        StudentDTO expected = new StudentDTO(id, "nombre", null, null, subjectDTOList);

        //Act
        StudentDTO student = studentDAO.findById(id);

        //Assert
        assertEquals(expected, student);

    }

    @Test
    public void findByIdTestInvalidId(){

        //Arrage
        Long id = studentDAO.getStudents().size() + 1L;


        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));

    }


}
