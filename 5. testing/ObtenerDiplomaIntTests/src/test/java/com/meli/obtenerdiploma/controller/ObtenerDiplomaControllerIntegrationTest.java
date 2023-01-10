package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach @AfterEach
    public void setUp() {
        initializeDatabase();
    }

    @AfterAll
    public static void runAfterAll() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Analyze score of a regular student")
    void analyzeScores() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L ))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("student1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno student1 ha obtenido un promedio de 6,00. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(6.0d));
    }

    @Test
    @DisplayName("Analyze score of a student with high grades")
    void analyzeScoresOfAHighGradeStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9999L ))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9999))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Pepo ha obtenido un promedio de 9,00. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.0d));
    }

    @Test
    @DisplayName("Try to analyze a non-existent student")
    void analyzeScoresOfANonExistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 123123L ))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 123123 no se encuetra registrado."));
    }

    private void initializeDatabase() {
        TestUtilsGenerator.emptyUsersFile();
        StudentDTO regularStudent = TestUtilsGenerator.getStudentWithId(1L);
        StudentDTO highGradesStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepo");
        Set<StudentDTO> students = new HashSet<>();
        students.add(regularStudent);
        students.add(highGradesStudent);

        TestUtilsGenerator.appendSetOfStudents(students);
    }
}