package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.MessageException;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    static ModelMapper mapper = new ModelMapper();
    static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }

    @Test
    @DisplayName("Integracion PostController lastTwoWeeksPostsFromFollowers valido")
    void lastTwoWeeksPostsFromFollowers()throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value("1"))
                .andReturn();
    }

    @Test
    @DisplayName("Integracion PostController addPost con datos validos")
    void addPost() throws Exception {

        PostRequestDto postRequestDto = TestUtil.postForSaveTest();
        PostResponseDto postResponseDto = this.mapper.map(postRequestDto, PostResponseDto.class);
        postResponseDto.setPostId(TestUtil.getPostNumber()+1);
        String payloadDto = writer.writeValueAsString(postRequestDto);
        String expect = writer.writeValueAsString(postResponseDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expect,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Integracion PostController addPost con userId invalido")
    void addPostInvalidUserId() throws Exception {
        PostRequestDto postRequestDto = TestUtil.postForSaveTest();
        postRequestDto.setUserId(-1);
        String payloadDto = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El id debe ser mayor a 0"))
                .andReturn();

    }
}
