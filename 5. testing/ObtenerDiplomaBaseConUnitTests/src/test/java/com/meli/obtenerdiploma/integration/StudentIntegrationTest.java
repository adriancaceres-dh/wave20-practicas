package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void postAnInvalidJson() throws Exception {
        String emptyBody = "";

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(emptyBody))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void registerValidStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("John Doe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentPayload = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentPayload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void registerInvalidStudent() throws Exception {
        StudentDTO invalidStudentDTO = new StudentDTO();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String invalidPayload = writer.writeValueAsString(invalidStudentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidPayload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void getExistentStudentWithValidId() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        StudentDTO studentDTO = createAndSaveValidStudent();
        ObjectWriter writer = new ObjectMapper()
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(studentDTO);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void getStudentThrowsWhenUnexistentId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 10000L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    private StudentDTO createAndSaveValidStudent() {
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("John Doe");
        studentDAO.save(studentDTO);
        return studentDTO;
    }
}
