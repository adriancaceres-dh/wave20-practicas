package com.bootcamp.be_java_hisp_w20_g4_pereyra.integration;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.ProductRequestDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDTO;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPublicationService {
    @Autowired
    MockMvc mockMvc;

    PostDTO postDTO;
    ProductRequestDTO productRequestDTO;

    @BeforeEach
    void setUp() {
        productRequestDTO = new ProductRequestDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        postDTO = new PostDTO(3, LocalDate.of(2023, 1,1), productRequestDTO, 10, 1500.50);
    }

    @Test
    @DisplayName("Test de integración de agregar una nueva publicación")
    public void addNewpostTest() throws Exception {
        String postDtoRequestJson = TestUtils.writer.writeValueAsString(postDTO);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        PublicationDTO publicationDtoExpected = new PublicationDTO(LocalDate.of(2023, 01, 01), productResponseDTO, 10, 1500.5);
        String expectedPublicationDto = TestUtils.writer.writeValueAsString(publicationDtoExpected);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedPublicationDto);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoRequestJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }


}
