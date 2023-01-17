package com.bootcamp.be_java_hisp_w20_g6.controller;


import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.request.ProductRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0005 - IT0001 Se valida que el endPoint /products/post guarde correctamente el post y devuelva un status OK")
    void souldSavePost() throws Exception{
         PostRequestDto postRequestDto = new PostRequestDto(1,"24-12-2022",100,
                 new ProductRequestDto(1,"Silla normal", "Gamer", "Racer", "Red Black", "Special Edition"),
                 1500.50
                 );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postRequestDto);

       MvcResult mvcResult = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDto))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        assertEquals("true",mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US0006 - IT0002 Valida que el endPoint /products/followed/1/list devuelva con un status OK")
    void shouldGetListProductsFollowed() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US0003 - IT0003 Valida que el endPoint /users/1/followers/list devuelva con un status OK")
    void shouldGetListfollowers() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US0004 - IT0004 Valida que el endPoint /users/1/followed/list devuelva con un status OK")
    void shouldGetListfollowed() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }


    @Test
    @DisplayName("US0002 - IT0005 Valida que el endPoint /users/1/followers/count devuelva con un status OK")
    void shouldCountListfollowers() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
