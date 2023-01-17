package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.BadRequestException;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.bootcamp.be_java_hisp_w20_g2_espindola.util.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Register a new Post - It should allow the creation of a new valid Post")
    void testAddNewProductOk() throws Exception{
        PostDTO post = generatePostDTO(1);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("Register a new Post - It should throw an exception when given an invalid user Id")
    void testAddNewProductInvalidUserId() throws Exception{
        PostDTO post = generatePostDTO(777);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("The given userId not exist."));

    }

    @Test
    @DisplayName("Register a new Post - It should throw an exception when given an invalid category code")
    void testAddNewProductInvalidCategory() throws Exception{
        PostDTO post = generatePostDTOInvalidCategory(1);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid category code"));

    }

    //Tests de validaciones al crear nuevos posts:
    @Test
    @DisplayName("Register a new Post - It should throw an exception when given an invalid product id")
    void testAddNewProductInvalidProductId() throws Exception{
        PostDTO post = generatePostDTOInvalidProductId(1);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El id_product debe ser mayor a cero."));

    }

    @Test
    @DisplayName("Register a new Post - It should throw an exception when given an invalid product id")
    void testAddNewProductInvalidType() throws Exception{
        PostDTO post = generatePostDTOInvalidType(1);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("La longitud del campo type no puede superar los 15 caracteres."));

    }

    @Test
    @DisplayName("Register a new Post - It should throw an exception when given an invalid product id")
    void testAddNewProductInvalidPrice() throws Exception{
        PostDTO post = generatePostDTOInvalidPrice(1);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El precio máximo por producto es 10.000.000"));

    }

    @Test
    @DisplayName("Posts in less than two weeks - It should list the posts of a seller that the user follows, which were posted in less than two weeks, unordered")
    void testSendLastPostOfFollowedOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].user_id").value(2))
                .andExpect(jsonPath("$.posts[0].date").value("17-01-2023"))
                .andExpect(jsonPath("$.posts[1].user_id").value(2))
                .andExpect(jsonPath("$.posts[1].date").value("10-01-2023"));
    }

    @Test
    @DisplayName("Posts in less than two weeks - It should throw an exception when given an invalid user Id")
    void testSendLastPostOfFollowedBadRequest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 999))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("The given userId not exist."));

    }

    @Test
    @DisplayName("Posts in less than two weeks - It should list the posts of a seller that the user follows, which were posted in less than two weeks, ascendant order")
    void testSendLastPostOfFollowedDateAsc() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).param("order","date_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].user_id").value(2))
                .andExpect(jsonPath("$.posts[0].date").value("10-01-2023"))
                .andExpect(jsonPath("$.posts[1].user_id").value(2))
                .andExpect(jsonPath("$.posts[1].date").value("17-01-2023"));
    }

    @Test
    @DisplayName("Posts in less than two weeks - It should list the posts of a seller that the user follows, which were posted in less than two weeks, descendant order")
    void testSendLastPostOfFollowedDateDesc() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).param("order","date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].user_id").value(2))
                .andExpect(jsonPath("$.posts[0].date").value("17-01-2023"))
                .andExpect(jsonPath("$.posts[1].user_id").value(2))
                .andExpect(jsonPath("$.posts[1].date").value("10-01-2023"));
    }

    @Test
    @DisplayName("Posts in less than two weeks - It should throw an exception when given an invalid order criteria")
    void testSendLastPostOfFollowedOrderNotValid() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).param("order","anything"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid Post sort criteria"));
    }

}