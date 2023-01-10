package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void setUp() {
        initializeDatabase();
    }

    @AfterAll
    public static void runAfterAll() {
        TestUtilsGenerator.emptyUsersFile();
    }
    
    @Test
    @DisplayName("Register a valid student")
    public void registerValidStudent() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepe");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Register a student with Invalid Name")
    public void registerStudentWithInvalidName() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("pepe");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    private String getStudentAsString(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        return writer.writeValueAsString(studentDTO);
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