package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Retornar DTO con el mensaje y promedio correspondiente")
    void testAnalyzeScores() throws Exception{
        StudentDTO expectedStudent = new StudentDTO(2L, "Ronaldo",
                "El alumno Ronaldo ha obtenido un promedio de 6.00. Puedes mejorar.", 6.0,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(expectedStudent);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",2L))
                .andReturn();

        Assertions.assertEquals(expectedJson,mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));

    }
}
