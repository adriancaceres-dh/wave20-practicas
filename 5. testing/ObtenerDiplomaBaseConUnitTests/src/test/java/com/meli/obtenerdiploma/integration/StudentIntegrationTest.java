package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
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
        StudentDTO studentDTO = createAndSaveValidStudent("John Doe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
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

    @Test
    public void modifyStudent() throws Exception {
        StudentDTO studentDTO = createAndSaveValidStudent("John Doe");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentPayload = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentPayload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyInvalidStudent() throws Exception {
        StudentDTO invalidStudentDTO = createAndSaveValidStudent("John Doe");
        invalidStudentDTO.setStudentName("");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String invalidPayload = writer.writeValueAsString(invalidStudentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPayload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void removeStudentOk() throws Exception {
        createAndSaveValidStudent("John Doe");

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void removeStudentWithUnexistentId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 10000L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    public void listAllStudents() throws Exception {
        List<StudentDTO> studentDTOList = new ArrayList<>(List.of(
                createAndSaveValidStudent("John Doe"),
                createAndSaveValidStudent("Johana Doe")
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<StudentDTO> resultList = new ObjectMapper()
                .readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), new TypeReference<ArrayList<StudentDTO>>() {});

        Comparator<StudentDTO> comp = Comparator.comparing(StudentDTO::getId);
        studentDTOList.sort(comp);
        resultList.sort(comp);

        assertEquals(studentDTOList, resultList);
    }

    private StudentDTO createAndSaveValidStudent(String name) {
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects(name);
        studentDAO.save(studentDTO);
        return studentDTO;
    }
}
