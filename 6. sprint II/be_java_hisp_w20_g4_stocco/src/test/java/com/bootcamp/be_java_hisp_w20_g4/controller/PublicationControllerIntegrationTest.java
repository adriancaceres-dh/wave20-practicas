package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.error.ErrorDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PublicationControllerIntegrationTest {
@Autowired
private MockMvc mockMvc;
    @Test
    void add() throws Exception{

        ProductResponseDTO product = new ProductResponseDTO(1,"Silla Gamer","Gamer", "Racer","Red Black","Special Edition");
        PublicationDTO publication1 = new PublicationDTO(LocalDate.of(2023, 1, 9),
                 product, 10, 10.0);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
               String payload = writer.writeValueAsString(publication1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andReturn();
    }

    @Test
    void  addException() throws  Exception{
        PublicationDTO emptyPublication = new PublicationDTO();
        ErrorDTO errorDTO = new ErrorDTO ("Not Valid Exception exception","El id no puede estar vacío");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payload = writer.writeValueAsString(emptyPublication);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andReturn();
    }
    @Test
    void last2WeeksPublications() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }
    @Test
    void last2WeeksPublicationsException()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",99))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void promoProductsOfSeller() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                .param("user_id", String.valueOf(1)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();
    }
}