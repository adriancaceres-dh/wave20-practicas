package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.ProductRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class PublicationControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test verifica el correcto funcionamiento de agregar una publicacion")
    void add() throws Exception {

        PostDTO postDTO =
                new PostDTO(1, LocalDate.of(2021, 11, 3),
                new ProductRequestDTO(2, "producto2", "tipo2", "nike", "red", "nota2"), 10, 15000.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String payloadDTO = writer.writeValueAsString(postDTO);
        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON)
                .content(payloadDTO))
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(15000.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value("03-11-2021"))
                .andReturn();
    }

    @Test
    void last2WeeksPublications() {
    }

    @Test
    void addPromo() {
    }

    @Test
    void promoProductsOfSeller() {
    }
}