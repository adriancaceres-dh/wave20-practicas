package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.controller;

import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil.getPostRequestDtoWithGivenProduct;
import static com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil.getPostResponseDtoWithGivenProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("Submit a post")
    public void whenGivenValidPost_addPost_shouldReturnPostResponseDto() throws Exception {
        Product product = Product.builder()
                .id(123)
                .name("Copa")
                .type("Glass")
                .brand("Stronglass")
                .color("Transparent")
                .build();

        PostRequestDto postRequestDto = getPostRequestDtoWithGivenProduct(product);
        String payloadJson = writer.writeValueAsString(postRequestDto);
        PostResponseDto postResponseDto = getPostResponseDtoWithGivenProduct(product);
        String expectedResponse = writer.writeValueAsString(postResponseDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

}
