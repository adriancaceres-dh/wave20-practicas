package com.meli.obtenerdiploma.controller.integration;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DecimalFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Caso feliz")
    void analyzeScoreOk() throws Exception {
        String message = "El alumno " + "Pedro" + " ha obtenido un promedio de "
                + new DecimalFormat("#0.00").format(7.33D) +". Puedes mejorar.";
        performTestOK(2L, 7.333333333333333D, message);

    }

    @Test
    @DisplayName("No se encuentra el estudiante")
    void analyzeScoreThrowsStudentNotFoundException() throws Exception {
        String message = "El alumno " + "Pedro" + " ha obtenido un promedio de "
                + new DecimalFormat("#0.00").format(7.33D) +". Puedes mejorar.";
        performTest(2L, 7.333333333333333D, message);


    }


    private void performTestOK(Long id, Double average, String message) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(average))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message)).andReturn();
    }



    private void performTest(Long id, Double average, String message) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", id)).andDo(print()).andReturn();
        Assertions.assertTrue(mvcResult.getResponse().getContentAsString().contains("El alumno con Id 5 no se encuetra registrado."));

    }

}