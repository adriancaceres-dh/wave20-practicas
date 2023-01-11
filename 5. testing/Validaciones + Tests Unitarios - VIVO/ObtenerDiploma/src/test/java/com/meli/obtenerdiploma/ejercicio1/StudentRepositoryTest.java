package com.meli.obtenerdiploma.ejercicio1;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.util;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IStudentDAO studentDAO;

    @BeforeEach
    private void setUp() {
        util.emptyFile();
    }

    @Test
    void findAllOk() {
        //arrange
        Set<StudentDTO> expectedStudent = new HashSet<>();

        List<SubjectDTO> subjects1 = util.getSubjects(false);
        StudentDTO studentDTO1 = util.getStudent(1L, "María", subjects1);
        expectedStudent.add(studentDTO1);
        studentDAO.save(studentDTO1);

        List<SubjectDTO> subjects2 = util.getSubjects(false);
        StudentDTO studentDTO2 = util.getStudent(2L, "René", subjects2);
        expectedStudent.add(studentDTO2);
        studentDAO.save(studentDTO2);

        List<SubjectDTO> subjects3 = util.getSubjects(false);
        StudentDTO studentDTO3 = util.getStudent(3L, "Tomas", subjects3);
        expectedStudent.add(studentDTO3);
        studentDAO.save(studentDTO3);
        //act
        Set<StudentDTO> studentsActual = studentRepository.findAll();

        //assert
        assertThat(studentsActual).containsAll(expectedStudent);
    }
}
