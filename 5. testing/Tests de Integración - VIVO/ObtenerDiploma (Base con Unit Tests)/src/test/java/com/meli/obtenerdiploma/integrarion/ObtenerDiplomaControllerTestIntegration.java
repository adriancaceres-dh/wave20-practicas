package com.meli.obtenerdiploma.integrarion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;


    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @Test
    void analyzeScoresOk() throws Exception{
        long studentId = 1L;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(studentId);
        studentDTO.setAverageScore(6.0);
        studentDTO.setMessage("El alumno student1 ha obtenido un promedio de 6.00. Puedes mejorar.");
        studentDAO.save(studentDTO);
        String studentDToJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.studentName").value("student1"))
                .andReturn();

        Assertions.assertEquals(studentDToJson, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    void analyzeScoresThrowExceptionMessage() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
