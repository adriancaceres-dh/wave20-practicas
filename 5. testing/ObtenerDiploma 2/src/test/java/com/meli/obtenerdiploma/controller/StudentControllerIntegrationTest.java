package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.meli.obtenerdiploma.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }

    /* ~~~~~~~~~~~~~ /student/registerStudent ~~~~~~~~~~~~~ */
    @Test
    @DisplayName("Register valid student")
    public void registerStudentOkIntegrationTest() throws Exception {
        StudentDTO studentDTO = buildValidStudent();
        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist())
                .andReturn();
    }

    public static Stream<Arguments> studentDtoAndErrorMsgProvider() {
        return Stream.of(
            arguments(buildInvalidStudentEmptyName(), "El nombre del estudiante no puede estar vacío."),
            arguments(buildInvalidStudentLowercaseName(), "El nombre del estudiante debe comenzar con mayúscula."),
            arguments(buildInvalidStudentNameGreaterThan50Characters(),"La longitud del nombre del estudiante no puede superar los 50 caracteres."),
            arguments(buildInvalidStudentEmptySubjects(), "La lista de materias no puede estar vacía."),
            arguments(buildInvalidStudentSubjectEmptyName(), "El nombre de la materia no puede estar vacío."),
            arguments(buildInvalidStudentSubjectNameStartsWithLowercase(), "El nombre de la materia debe comenzar con mayúscula."),
            arguments(buildInvalidStudentSubjectNameGreaterThan30Characters(), "La longitud del nombre de la materia no puede superar los 30 caracteres."),
            arguments(buildInvalidStudentSubjectEmptyScore(), "La nota de la materia no puede estar vacía."),
            arguments(buildInvalidStudentSubjectScoreGreaterThan10(), "La nota máxima de la materia es de 10 pts."),
            arguments(buildInvalidStudentSubjectScoreLesserThan0(), "La nota mínima de la materia es de 0 pts.")
        );
    }

    @ParameterizedTest
    @MethodSource("studentDtoAndErrorMsgProvider")
    public void registerStudentInvalidIntegrationTest(StudentDTO studentDto, String errorMsg) throws Exception{
        String payloadJson = writer.writeValueAsString(studentDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value(errorMsg))
                .andReturn();
    }

    /* ~~~~~~~~~~~~~ /student/getStudent ~~~~~~~~~~~~~ */
    @Test
    @DisplayName("Get valid student")
    public void getStudentOkIntegrationTest() throws Exception {
        SubjectDTO sub1 = new SubjectDTO("Mátematicas", 10.0);
        SubjectDTO sub2 = new SubjectDTO("Lógica", 10.0);
        StudentDTO studentDTO = new StudentDTO(2L, "Jorge", "Un mensaje", 10.0, List.of(sub1, sub2));
        String expectedResponse = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Get invalid student throws")
    public void getStudentInvalidIntegrationTest() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 1 no se encuetra registrado.");
        String expectedResponse = writer.writeValueAsString(errorDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /* ~~~~~~~~~~~~~ /student/modifyStudent ~~~~~~~~~~~~~ */
    @Test
    @DisplayName("Modify valid student")
    public void modifyStudentOkIntegrationTest() throws Exception {
        StudentDTO studentDTO = buildValidStudent();
        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    @DisplayName("Modify invalid student")
    public void modifyStudentInvalidIntegrationTest() throws Exception {
        StudentDTO studentDTO = buildInvalidStudentEmptySubjects();
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "La lista de materias no puede estar vacía.");

        String payloadJson = writer.writeValueAsString(studentDTO);
        String errorExpected = writer.writeValueAsString(errorDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

        assertEquals(errorExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /* ~~~~~~~~~~~~~ /student/removeStudent ~~~~~~~~~~~~~ */
    @Test
    @DisplayName("Get valid student")
    public void removeStudentOkIntegrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    @DisplayName("Get invalid student throws")
    public void removeStudentInvalidIntegrationTest() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 1 no se encuetra registrado.");
        String expectedResponse = writer.writeValueAsString(errorDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /* ~~~~~~~~~~~~~ /student/listStudent ~~~~~~~~~~~~~ */
}
