package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.parameter_resolver.StudentRepositoryParameterResolver;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(StudentRepositoryParameterResolver.class)
public class StudentRepositoryTests {

    private final IStudentRepository studentRepository;

    public StudentRepositoryTests(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    void findAllOk() {
        // arrange
        int emptySize = 0;
        // act
        Set<StudentDTO> students = studentRepository.findAll();
        // assert
        assertNotEquals(emptySize, students.size());
    }
}
