package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialMeliIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("IT-01-> Check user can follow seller when both exist")
    public void followTestUserAndSellerExist() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{userIdToFollow}",1,5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.ok").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("New Follower add successfully"));
    }

    @Test
    @DisplayName("IT-02-> Check user cannot follow seller when user does not exist")
    public void followTestUserDosentExist() throws  Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{userIdToFollow}",7,5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Operation failed exception"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("try to add new follow failed"));


    }

    @Test
    @DisplayName("IT-03-> Get how many followers a seller have")
    public void userFollowersCountTestExistingUser() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(6))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("seller4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(1));
    }
    @Test
    @DisplayName("IT-04-> Check  error of trying to get the amount of followers of a non existent seller")
    public void userFollowersCountTestNotExistingUser() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Not found exception"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist id"));
    }


    @Test
    @DisplayName("IT-05-> Check posting a valid post")
    public void postProductTestValidPost() throws Exception{
        PostRequestDTO payloadDTO = new PostRequestDTO();
        ProductDTO productDTO = new ProductDTO(10,"silla","gamer","racer","red","special edition");
        payloadDTO.setUser_id(6);
        payloadDTO.setDate(LocalDate.now());
        payloadDTO.setCategory(1);
        payloadDTO.setProductDTO(productDTO);
        payloadDTO.setPrice(1500.0);

        ResponseDTO responseDTO = new ResponseDTO(true,"Post added successfully");

        ObjectWriter writer = new ObjectMapper().registerModule( new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ok").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post added successfully"))
                .andReturn();
        Assertions.assertEquals(responseJson,result.getResponse().getContentAsString());

    }
    @Test
    @DisplayName("IT-06-> Check posting a post with special characters")
    public void postProductTestSpecialCharacters() throws Exception{
        PostRequestDTO payloadDTO = new PostRequestDTO();
        ProductDTO productDTO = new ProductDTO(11,"silla@@","gamer~","racer∂","red","special edition");
        payloadDTO.setUser_id(6);
        payloadDTO.setDate(LocalDate.now());
        payloadDTO.setCategory(1);
        payloadDTO.setProductDTO(productDTO);
        payloadDTO.setPrice(150.0);

        ErrorDTO expectedDTO = new ErrorDTO("MethodArgumentNotValidException","El campo no puede poseer caracteres especiales");

        ObjectWriter writer = new ObjectMapper().registerModule( new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String expectedResponseJson = writer.writeValueAsString(expectedDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El campo no puede poseer caracteres especiales"))
                .andReturn();
        Assertions.assertEquals(expectedResponseJson,result.getResponse().getContentAsString());

    }

}
