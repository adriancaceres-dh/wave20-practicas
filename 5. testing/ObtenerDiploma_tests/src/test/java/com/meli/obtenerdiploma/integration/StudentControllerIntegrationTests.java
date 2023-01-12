package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestsUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static final String prefix = "/student";

    public StudentControllerIntegrationTests() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach @AfterEach
    public void setUp() {
        try {
            TestsUtilsGenerator.resetUsersFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void registerStudentOk() throws Exception {
        // arrange
        StudentDTO payloadDTO = new StudentDTO(4L, "Alex", null, null, List.of(new SubjectDTO("Negocios", 8D)));
        String payloadJson = writer.writeValueAsString(payloadDTO);
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post( prefix + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        // assert
        assertEquals("", result.getResponse().getContentAsString());
    }

    @Test
    void registerStudentMissingBody() throws Exception {
        // arrange
        String name = "HttpMessageNotReadableException";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post( prefix + "/registerStudent"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void registerStudentInvalidStudent() throws Exception {
        // arrange
        StudentDTO payloadDTO = new StudentDTO(4L, "alex", null, null, List.of(new SubjectDTO("Negocios", 8D)));
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String name = "MethodArgumentNotValidException";
        String description = "El nombre del estudiante debe comenzar con mayúscula.";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post( prefix + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(description))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void registerStudentInvalidSubject() throws Exception {
        // arrange
        StudentDTO payloadDTO = new StudentDTO(4L, "Alex", null, null, List.of(new SubjectDTO("Negocios", -1D)));
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String name = "MethodArgumentNotValidException";
        String description = "La nota mínima de la materia es de 0 pts.";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post( prefix + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(description))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void getStudentOk() throws Exception {
        // arrange
        Long id = 3L;
        String name = "Fatima";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get( prefix + "/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(name))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void getStudentNotFound() throws Exception {
        // arrange
        Long id = 100L;
        String name = "StudentNotFoundException";
        String description = "El alumno con Id 100 no se encuentra registrado.";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get( prefix + "/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(description))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void modifyStudentOk() throws Exception {
        // arrange
        StudentDTO payloadDTO = new StudentDTO(1L, "Juan", null, null, List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        payloadDTO.setStudentName("Juan J");
        String payloadJson = writer.writeValueAsString(payloadDTO);
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post( prefix + "/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        // assert
        assertEquals("", result.getResponse().getContentAsString());
    }

    @Test
    void removeStudentOk() throws Exception {
        // arrange
        Long id = 2L;
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get( prefix + "/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        // assert
        assertEquals("", result.getResponse().getContentAsString());
    }

    @Test
    void listStudentsOk() throws Exception {
        // arrange
        Set<String> nameSet = Set.of("Juan", "Pedro", "Fatima");
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get( prefix + "/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName", in(nameSet)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentName", in(nameSet)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].studentName", in(nameSet)))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }
}
