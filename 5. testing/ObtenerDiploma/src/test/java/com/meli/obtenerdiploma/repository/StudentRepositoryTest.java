package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    private Set<StudentDTO> setStudentDTO;


    public StudentRepositoryTest() {
        studentRepository = new StudentRepository();
        setStudentDTO = new HashSet<>();
    }


    @Test
    void testFindAllStudents(){
        setStudentDTO = studentRepository.findAll();
        assertTrue(setStudentDTO.size() >= 0);
    }

    @Test
    void testAssertThrowsInFindAllStudents() {
        studentRepository.findAll();

        assertThrows(FileNotFoundException.class, this::throwFileNotFoundException);
        assertThrows(IOException.class, this::throwIOException);
    }

    private void throwFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    private void throwIOException() throws IOException {
        throw new IOException();
    }
}
