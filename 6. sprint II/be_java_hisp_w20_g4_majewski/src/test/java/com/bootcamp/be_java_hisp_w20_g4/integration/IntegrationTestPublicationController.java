package com.bootcamp.be_java_hisp_w20_g4.integration;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.ProductRequestDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPublicationController {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("T- Individual - Valida la creación de una publicación")
    void addPostIntegrationTest() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        ProductRequestDTO productRequestDTO = new ProductRequestDTO(2, "producto2", "tipo2", "nike", "red", "nota2");
        PostDTO postDTO = new PostDTO(1,LocalDate.now(), productRequestDTO, 20, 100.0);
        String payload = writer.writeValueAsString(postDTO);

        ProductResponseDTO expectedProduct = new ProductResponseDTO(2,"producto2", "tipo2", "nike", "red", "nota2");
        PublicationDTO expectedPublication = new PublicationDTO(LocalDate.now(), expectedProduct, 20, 100.0);
        String json = writer.writeValueAsString(expectedPublication);

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expextedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(json);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(expectedJson);

    }
}
