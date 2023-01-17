package com.bootcamp.be_java_hisp_w20_g6.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("00010 Verificación - Publicacion de producto")
    void testNewProduct() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{" +
                                        "\"user_id\": 1," +
                                        "\"date\": \"24-10-2024\"," +
                                        "\"product\": {" +
                                        "\"product_id\": 9," +
                                        "\"product_name\": \"Cama King\"," +
                                        "\"type\": \"Hogar\"," +
                                        "\"brand\": \"Pullman\"," +
                                        "\"color\": \"Gray\"," +
                                        "\"notes\": \"Collection\"" +
                                        "}," +
                                        "\"category\": 111," +
                                        "\"price\": 2400.40" +
                                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value(true));
    }
    @Test
    @DisplayName("00011 Verificación - Publicación con datos errados")
    void testNewProductException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post", "{xxxx}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    @DisplayName("00012 Verificación - Lista de productos de un usuario.")
    void testProductsFollowedList() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1));
    }
    @Test
    @DisplayName("00013 Verificación - Lista de productos de un usuario que no existe. ")
    void testProductsFollowedListException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 99))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("UserNotFoundException"));
    }
}

