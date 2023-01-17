package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.ProductRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NewPostTest {
    @Autowired
    private MockMvc mvc;

    private static ObjectWriter writer;

    private static String url;
    private static LocalDate currentDate;
    private static int userId;
    private static int category;
    private static double price;
    private static ProductRequestDTO product;
    private static String payload;

    private final String contentType = "application/json";

    @BeforeAll
    public static void setDefault(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        userId = 1;
        category = 99;
        price = 9999.99;
        product = new ProductRequestDTO(
                1,
                "piedra filosofal",
                "sobrenatural",
                "magia",
                "dorado",
                "convierte en oro todo lo que toca");
    }

    @BeforeEach
    public void setDefaultBeforeEach() throws JsonProcessingException {
        payload = writer.writeValueAsString(new PostRequestDTO(userId, currentDate, product, category, price));
        currentDate = LocalDate.now();
    }

    @Test
    @DisplayName("New post successfully done!")
    public void newPostTest() throws Exception {
        url = "/products/post";
        mvc.perform(
                MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.date").value(currentDate.toString()))
                .andExpect(jsonPath("$.category").value(category))
                .andExpect(jsonPath("$.price").value(price))
                .andExpect(jsonPath("$.product.type").value(product.getType()))
                .andExpect(jsonPath("$.product.brand").value(product.getBrand()))
                .andExpect(jsonPath("$.product.color").value(product.getColor()))
                .andExpect(jsonPath("$.product.notes").value(product.getNotes()));
    }

    @Test
    @DisplayName("Wrong url")
    public void newPostWrongUrlTest() throws Exception {
        url = "/products/error";
        mvc.perform(
                MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
