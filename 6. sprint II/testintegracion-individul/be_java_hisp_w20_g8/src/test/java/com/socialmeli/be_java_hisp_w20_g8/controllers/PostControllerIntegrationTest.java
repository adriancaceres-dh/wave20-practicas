package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.ErrorDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCreateNewPost()throws Exception{

        String expectedMessage ="Post added successfully";

        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red and Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(6);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 3));
        postRequestDTO.setProductDTO(productDTO);
        postRequestDTO.setCategory(90);
        postRequestDTO.setPrice(1500.50);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto)
                )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedMessage))
                ;
    }
    @Test
    void testCreateNewPostException()throws Exception{

        ErrorDTO errorDto =new ErrorDTO("MethodArgumentNotValidException","El ID de la categoria no puede estar vacio");

        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red and Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(6);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 3));
        postRequestDTO.setProductDTO(productDTO);
        postRequestDTO.setPrice(1500.50);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postRequestDTO);
        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto)
                )
                .andDo(print()).andReturn();

        assertEquals(errorExpected, mvcResult.getResponse().getContentAsString());
    }

}