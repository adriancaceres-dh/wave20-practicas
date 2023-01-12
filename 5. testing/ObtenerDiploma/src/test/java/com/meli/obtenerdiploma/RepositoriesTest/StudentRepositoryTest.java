package com.meli.obtenerdiploma.RepositoriesTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @Test
    void findAll() {
        // Arrange
        Set<StudentDTO> loadedDataExpected = new HashSet<>();
        loadedDataExpected.addAll(Set.of(new StudentDTO(2L, "Pedro", null, null, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0))),
                new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)))));
        // Act
        Set<StudentDTO> loadedDataResult = studentRepository.findAll();
        // Assert);
        assertTrue(loadedDataExpected.size() == loadedDataResult.size());
        assertEquals(loadedDataExpected,loadedDataResult);
    }
}

