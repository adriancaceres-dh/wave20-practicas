package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setup() {
        TestUtilsGenerator.emptyUsersFile();
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentWithLowerAverage = TestUtilsGenerator.getStudentWith3Subjects("John Doe");
        StudentDTO studentWithGreaterAverage = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Johana Doe");
        studentDAO.save(studentWithLowerAverage);
        studentDAO.save(studentWithGreaterAverage);
    }

    @Test
    public void analyzeScoresReturnsHighAverage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Johana Doe"))
                .andExpect(jsonPath("$.message")
                        .value("El alumno Johana Doe ha obtenido un promedio de 9.00. Felicitaciones!"))
                .andExpect(jsonPath("$.averageScore")
                        .value(9.0));
    }

    @Test
    public void analizeScoresReturnsCouldBeBetter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("John Doe"))
                .andExpect(jsonPath("$.message")
                        .value("El alumno John Doe ha obtenido un promedio de 6.00. Puedes mejorar."))
                .andExpect(jsonPath("$.averageScore")
                        .value(6.0));
    }

    @Test
    public void nonExistantIdThrowsExceptionMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 27L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id 27 no se encuentra registrado."));
    }
}
