package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.meli.obtenerdiploma.repository.StudentDTOUtil.createStudentWithSubject;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    private IStudentRepository studentRepository;
    private IStudentDAO studentDAO;

    @Autowired
    public StudentRepositoryTest(IStudentRepository studentRepository, IStudentDAO studentDAO) {
        this.studentRepository = studentRepository;
        this.studentDAO = studentDAO;
    }

    @Test
    void findAllReturnsAllStudents() {
        Long studentId = 1L;
        StudentDTO studentDTO1 = createStudentWithSubject();
        studentDTO1.setId(studentId++);
        StudentDTO studentDTO2 = createStudentWithSubject();
        studentDTO2.setId(studentId);
        studentDTO2.setStudentName("John Doe");

        studentDAO.save(studentDTO1);
        studentDAO.save(studentDTO2);

        Set<StudentDTO> expectedSet = new HashSet<>(Set.of(studentDTO1, studentDTO2));

        assertEquals(expectedSet, studentRepository.findAll());

        studentDAO.delete(studentDTO1.getId());
        studentDAO.delete(studentDTO2.getId());
    }

}