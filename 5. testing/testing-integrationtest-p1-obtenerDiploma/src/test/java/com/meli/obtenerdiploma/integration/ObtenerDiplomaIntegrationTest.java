package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;
    private StudentDAO studentDAO;
    private StudentDTO lowScoreStudent, highScoreStudent;
    private SubjectDTO sbj1, sbj2, sbj3, sbj4;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        sbj1 = new SubjectDTO("Chino", 3.0);
        sbj2 = new SubjectDTO("Alemán", 5.0);
        sbj3 = new SubjectDTO("Inglés", 9.0);
        sbj4 = new SubjectDTO("Español", 10.0);

        lowScoreStudent = new StudentDTO(
                1L,
                "Alicia",
                "El alumno Alicia ha obtenido un promedio de 4. Puedes mejorar.",
                4.0,
                List.of(sbj1, sbj2)
        );
        highScoreStudent = new StudentDTO(
                2L,
                "Benito",
                "El alumno Benito ha obtenido un promedio de 9.5. Felicitaciones!",
                9.5,
                List.of(sbj3, sbj4)
        );

        studentDAO = new StudentDAO();
        studentDAO.save(lowScoreStudent);
        studentDAO.save(highScoreStudent);
    }

    @Test
    public void analyzeLowScoreStudentTest() throws Exception {
        perform(lowScoreStudent);
    }

    @Test
    public void analyzeHighScoreStudentTest() throws Exception {
        perform(highScoreStudent);
    }

    @Test
    public void analyzeInvalidStudentScoreTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 0))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    private void perform(StudentDTO student) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",student.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.message").value(student.getMessage()))
                .andExpect(jsonPath("$.averageScore").value(student.getAverageScore()))
                .andReturn();

        assertEquals(writer.writeValueAsString(student), mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
