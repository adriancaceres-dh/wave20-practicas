package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoresBelow9() throws Exception {
        // arrange
        Long id = 1L;
        String studentName = "Juan";
        String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void analyzeScoresAbove9() throws Exception {
        // arrange
        Long id = 3L;
        String studentName = "Fatima";
        String message = "El alumno Fatima ha obtenido un promedio de 10. Felicitaciones!";
        String expectedType = "application/json";
        // act && assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(studentName))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message))
                .andReturn();
        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void analyzeScoresNotFound() throws Exception {
        // arrange
        Long id = 100L;
        String name = "StudentNotFoundException";
        String description = "El alumno con Id 100 no se encuentra registrado.";
        String expectedType = "application/json";
        // act & assert
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(description))
                .andReturn();
        // assert
        assertEquals(expectedType, mvcResult.getResponse().getContentType());
    }
}
