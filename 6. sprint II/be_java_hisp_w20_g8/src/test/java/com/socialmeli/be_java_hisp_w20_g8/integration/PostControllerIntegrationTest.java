package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.ErrorDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper mapper;

    public PostControllerIntegrationTest () {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule());
    }

    @Test
    void postPostOk() throws Exception {
        // arrange
        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red and Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO(6, LocalDate.of(2023, 1, 16), productDTO, 90, 1500.50);

        ResponseDTO responseDTO = new ResponseDTO(true, "Post added successfully");

        String payloadJson = mapper.writeValueAsString(postRequestDTO);
        String responseJson = mapper.writeValueAsString(responseDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    void postPostInvalidPayload() throws Exception {
        // arrange
        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red and Black", "Special % Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO(6, LocalDate.of(2023, 1, 16), productDTO, 90, 1500.50);

        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException", "El campo no puede poseer caracteres especiales");

        String payloadJson = mapper.writeValueAsString(postRequestDTO);
        String responseJson = mapper.writeValueAsString(errorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    void findAllPostsByIdUserOk() throws Exception {
        // arrange
        int userId = 2;
        String expectedType = "application/json";

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_user").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").isArray())
                .andReturn();

        // assert
        assertEquals(expectedType, result.getResponse().getContentType());
    }

    @Test
    void findAllPostsByIdUserInvalidUserId() throws Exception {
        // arrange
        int userId = -2;

        ErrorDTO errorDTO = new ErrorDTO("ConstraintViolationException", "El ID deber ser mayor a cero");
        String responseJson = mapper.writeValueAsString(errorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}
