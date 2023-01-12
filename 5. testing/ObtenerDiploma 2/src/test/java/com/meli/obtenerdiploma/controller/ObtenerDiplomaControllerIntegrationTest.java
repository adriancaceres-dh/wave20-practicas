package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Analyze scores of regular student")
    public void analyzeScoresRegularStudentOkIntegrationTest() throws Exception{
        // Arrange
        String expectedMessage = "El alumno John Doe ha obtenido un promedio de 8. Puedes mejorar.";
        // Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("John Doe"))
                .andExpect(jsonPath("$.averageScore").value(8.0))
                .andExpect(jsonPath("$.message").value(expectedMessage))
                .andReturn();
    }

    @Test
    @DisplayName("Analyze scores of honorable student")
    public void analyzeScoresHonorableStudentOkIntegrationTest() throws Exception{
        // Arrange
        String expectedMessage = "El alumno Jorge ha obtenido un promedio de 10. Felicitaciones!";
        // Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Jorge"))
                .andExpect(jsonPath("$.averageScore").value(10.0))
                .andExpect(jsonPath("$.message").value(expectedMessage))
                .andReturn();
    }

    @Test
    @DisplayName("Analyze scores of non-existent student")
    public void analyzeScoresNonExistentStudentIntegrationTest() throws Exception{
        // Arrange
        String expectedMessage = "El alumno con Id 5 no se encuetra registrado.";
        // Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 5))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value(expectedMessage))
                .andReturn();
    }
}
