package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.ProductRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class PublicationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void addPublicationTest() throws Exception {
        PostDTO publicationDTO = new PostDTO(1, LocalDate.of(2022,11,2), new ProductRequestDTO(4,"producto4","tipo4","adidas","green","nota4"),20,1200.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String payloadDto = writer.writeValueAsString(publicationDTO);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value(20))
                .andReturn();


    }


}
