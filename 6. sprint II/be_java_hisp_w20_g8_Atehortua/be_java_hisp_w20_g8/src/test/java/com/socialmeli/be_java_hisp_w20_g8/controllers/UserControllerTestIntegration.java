package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserFollowedController() throws Exception{
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("user1")).andReturn();

    }

    @Test
    void testPostsPostOk() throws Exception {
        // arrange
        ProductDTO productDTO = new ProductDTO(5, "Gamer Chair", "Gamer", "Racer", "Red & Black", "Special Edition");
        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUser_id(6);
        postRequestDTO.setDate(LocalDate.of(2023, 1, 16));
        postRequestDTO.setProductDTO(productDTO);
        postRequestDTO.setCategory(90);
        postRequestDTO.setPrice(1500.50);

        ResponseDTO responseDTO = new ResponseDTO(true, "Post added successfully");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(postRequestDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}
