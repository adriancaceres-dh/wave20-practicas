package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDAOTest {
    private final StudentDAO studentDAO;
    private List<SubjectDTO> subjectDTOList;
    private StudentDTO studentDTO;

    private Long student;

    public StudentDAOTest() {
        int num = (int)(Math.random()*10+1);
        student = Long.valueOf(String.valueOf(num));

        this.studentDAO = new StudentDAO();
        subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths",4.0) );
        subjectDTOList.add(new SubjectDTO("History",4.5) );
        studentDTO = new StudentDTO(student,"Camilo","Buen estudiante"
                , 4.0, subjectDTOList );
    }


    @Test
    void testSaveEstudent(){
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }


    @Test
    void testFindStudentById(){
        studentDAO.save(studentDTO);
        StudentDTO student = studentDAO.findById(studentDTO.getId());

        assertNotNull(student);
        assertEquals(student.getId(),studentDTO.getId());
    }
    @Test
    void testModifyStudent(){
        studentDAO.save(studentDTO);
        assertThrows(StudentNotFoundException.class, this::throwNotFoundException);
        assertEquals(studentDTO.getStudentName(),studentDAO.findById(student).getStudentName());
    }

    @Test
    void deleteStudent(){
        boolean result = studentDAO.delete(student);
        assertTrue(result);
    }

    private void throwNotFoundException() throws StudentNotFoundException {
        throw new StudentNotFoundException(student);
    }


}
