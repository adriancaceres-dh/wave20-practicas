package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.ErrorDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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

    @Test
    @DisplayName("Testing of a new post")
    void testPostPostOk() throws Exception {
        // arrange
        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(6);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 16));
        postRequestDTO.setProductDTO(productDTO);
        postRequestDTO.setCategory(90);
        postRequestDTO.setPrice(1500.50);

        ResponseDTO excpectedResponseDTO = new ResponseDTO(true, "Post added successfully");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();


        String payloadJson = writer.writeValueAsString(postRequestDTO);
        String responseJson = writer.writeValueAsString(excpectedResponseDTO);

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
    @DisplayName("Testing of a new post but the seller doesn't exist")
    void testPostPostNotOk() throws Exception {
        // arrange
        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(1);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 16));
        postRequestDTO.setProductDTO(productDTO);
        postRequestDTO.setCategory(90);
        postRequestDTO.setPrice(1500.50);

        ErrorDTO excpectedErrorDTO = new ErrorDTO("Not found exception", "Doesn't exist seller");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();


        String payloadJson = writer.writeValueAsString(postRequestDTO);
        String responseJson = writer.writeValueAsString(excpectedErrorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert

        Assertions.assertEquals(responseJson,result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Testing of a new post but throwing exception in the productDTO validation")
    void testPostPostNotOkv2() throws Exception {
        // arrange
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(1);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 16));
        postRequestDTO.setProductDTO(null);
        postRequestDTO.setCategory(90);
        postRequestDTO.setPrice(1500.50);

        ErrorDTO excpectedErrorDTO = new ErrorDTO("MethodArgumentNotValidException", "El producto no puede estar vacio");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();


        String payloadJson = writer.writeValueAsString(postRequestDTO);
        String responseJson = writer.writeValueAsString(excpectedErrorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert

        Assertions.assertEquals(responseJson,result.getResponse().getContentAsString());

    }


}
