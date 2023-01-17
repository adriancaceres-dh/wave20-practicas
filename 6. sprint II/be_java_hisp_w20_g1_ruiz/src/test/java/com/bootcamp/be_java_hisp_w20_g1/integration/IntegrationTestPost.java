package com.bootcamp.be_java_hisp_w20_g1.integration;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPost {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void beforEach() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    public void shouldSaveCorrectlyAPost() throws Exception {

        PostResponseDto postDto = TestUtil.getPostRequestDto();

        String payloadJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(postDto.getUserId()))
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.category").value(postDto.getCategory()))
                .andExpect(jsonPath("$.price").value(postDto.getPrice()))
                .andExpect(jsonPath("$.product.product_id").value(postDto.getProduct().getProductId()))
                .andExpect(jsonPath("$.product.product_name").value(postDto.getProduct().getProductName()))
                .andExpect(jsonPath("$.product.type").value(postDto.getProduct().getType()))
                .andExpect(jsonPath("$.product.brand").value(postDto.getProduct().getBrand()))
                .andExpect(jsonPath("$.product.color").value(postDto.getProduct().getColor()))
                .andReturn();
    }

    @Test
    public void shouldFailPostForInavlidDate() throws Exception {

        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setDate(null);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "date", "La fecha no puede estar vacía.");
    }

    @Test
    public void shouldFailPostForInavlidUserId() throws Exception {
        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setUserId(0);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "userId", "El id debe ser mayor a 0");
    }

    @Test
    public void shouldFailPostForInavlidCategory() throws Exception {
        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setCategory(0);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "category", "El campo debe ser mayor a 0");
    }

    @Test
    public void shouldFailPostForInavlidPrice() throws Exception {
        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setPrice(0);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "price", "El precio mínimo por producto es de 0.1");
    }

    @Test
    public void shouldFailPostForHigherPrice() throws Exception {
        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setPrice(100000000000000.0);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "price", "El precio máximo por producto es de 10.000.000");
    }

    @Test
    public void shouldFailPostForNullProduct() throws Exception {
        PostResponseDto postDto = TestUtil.getPostRequestDto();
        postDto.setProduct(null);

        String payloadJson = writer.writeValueAsString(postDto);

        this.doBasicInavlidTest(payloadJson, "product", "Debe ingresar un producto");
    }

    private void doBasicInavlidTest(String payloadJson, String field, String reason) throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.invalid_validations[?(@.field == \""+field+"\" && @.reason == \""+reason+"\")]").exists())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
