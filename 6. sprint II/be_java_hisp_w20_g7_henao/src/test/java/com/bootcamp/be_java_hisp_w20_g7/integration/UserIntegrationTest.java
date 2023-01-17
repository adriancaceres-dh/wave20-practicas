package com.bootcamp.be_java_hisp_w20_g7.integration;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void followersIntegrationTest() throws Exception {

        UserFollowersDto userFollowersDto = new UserFollowersDto(3, "Soraya",new ArrayList<>(List.of(
                new UserDto(1,"Sebastian"),
                new UserDto(2,"Manuel"),
                new UserDto(8,"Juan"),
                new UserDto(4,"Ronald")
        )));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String answerExpected = writer.writeValueAsString(userFollowersDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "3"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Soraya"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(3)).andReturn();

        Assertions.assertEquals(answerExpected,mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void followersCountIntegrationsTest() throws Exception{
        // Test para verificar los tres campos que devuelve la cantidad de followers de un usuario
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count","3"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Soraya"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(4));
    }

    @Test
    public void followIntegrationsTest() throws Exception{
        // Test para verificar el follow de un usuario a otro
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","3","2"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    public void unfollowIntegrationsTest() throws Exception{
        // Test para verificar el unfollow de un usuario a otro
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnollow}","2","3"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("text/plain;charset=UTF-8"));
    }
}
