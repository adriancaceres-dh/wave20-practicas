package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.ProductRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    /*
    Crea un DTO de una publicación y la añade a través del endpoint provisto por la API.
    Verifica que todos los campos de la respuesta sean correctos, y que esta sea igual al DTO creado
     */
    @Test
    public void newOKPostTest() throws Exception {
        ProductRequestDTO productReq = new ProductRequestDTO(36, "Antibiotic", "Neomycin", "CVS", "green", "Diverse uniform process improvement");
        PostRequestDTO fineReq = new PostRequestDTO(3, LocalDate.now(), productReq, 20, 600);
        String payload = writer.writeValueAsString(fineReq);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").content(payload).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(fineReq.getUserId()))
                .andExpect(jsonPath("$.date").value(fineReq.getDate().toString()))
                .andExpect(jsonPath("$.category").value(fineReq.getCategory()))
                .andExpect(jsonPath("$.price").value(fineReq.getPrice()))
                .andExpect(jsonPath("$.product.id").value(productReq.getId()))
                .andExpect(jsonPath("$.product.name").value(productReq.getName()))
                .andExpect(jsonPath("$.product.type").value(productReq.getType()))
                .andExpect(jsonPath("$.product.brand").value(productReq.getBrand()))
                .andExpect(jsonPath("$.product.color").value(productReq.getColor()))
                .andExpect(jsonPath("$.product.notes").value(productReq.getNotes()))
                .andReturn();

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Post newPost = mapper.map(fineReq, Post.class);
        newPost.setId(40);
        PostResponseDTO res = mapper.map(newPost, PostResponseDTO.class);
        assertEquals(writer.writeValueAsString(res), mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /*
    Crea un DTO vacío de una publicación y la añade a través del endpoint provisto por la API.
    Verifica que la respuesta sea del tipo Bad Request
     */
    @Test
    public void newExceptionPostTest() throws Exception {
        PostRequestDTO wrongReq = new PostRequestDTO();
        String payload = writer.writeValueAsString(wrongReq);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").content(payload).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"));
    }
}