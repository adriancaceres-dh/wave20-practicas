package com.bootcamp.be_java_hisp_w20_g6.controller;


import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.ErrorResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {


    @Autowired
    MockMvc mockMvc;

    /*METHODS GET INTEGRATION*/

    @Test
    void followersCountTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("pablito1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followersListTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("pedrito1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").value(Matchers.empty()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").doesNotExist())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followedListTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("kardashianOficial"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").value(Matchers.empty()))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followedUserNotFoundExceptionListTest() throws Exception{


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 40))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UserNotFoundException"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void listProductsTest() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").value(Matchers.empty()))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    /*METHODS POST INTEGRATION*/

    @Test
    void postArgumentNotValidExceptionTest() throws Exception{
        ProductRequestDto productRequestDto =  new ProductRequestDto(1,"Silla Gamer", "Gamer",
                "Racer", "Red & Black", "Especial Edition");

        PostRequestDto postRequestDto = new PostRequestDto(1,"17-01-2022",100,
                productRequestDto, 1500.50, true,0.0);

        ErrorResponseDto errorResponseDto = new ErrorResponseDto("MethodArgumentNotValidException",
                "El campo no puede poseer caracteres especiales.");


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postRequestDto);
        String errorExpected = writer.writeValueAsString(errorResponseDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void postTest() throws Exception{
        ProductRequestDto productRequestDto =  new ProductRequestDto(1,"Silla Gamer", "Gamer",
                "Racer", "Red y Black", "Especial Edition");

        PostRequestDto postRequestDto = new PostRequestDto(1,"17-01-2022",100,
                productRequestDto, 1500.50, true,0.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals("true",mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followUserTest() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals("true",mvcResult.getResponse().getContentAsString());
    }

    @Test
    void unfollowNotFoundExceptionTest() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 3))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("FollowerNotFoundException"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followSameUserExceptionTest() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("SameUserException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El usuario no se puede seguir a si mismo."))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
