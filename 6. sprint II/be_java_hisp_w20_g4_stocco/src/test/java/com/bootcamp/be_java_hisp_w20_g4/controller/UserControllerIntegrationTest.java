package com.bootcamp.be_java_hisp_w20_g4.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
@Autowired
private MockMvc mockMvc;
    @Test
    void follow() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("rodri"))
                .andReturn();

    }

    @Test
    void followersCount() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }

    @Test
    void followers() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }

    @Test
    void followed() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andReturn();
    }
/*
    @Test
    void unfollow() throws  Exception{
        //hacer que el user_1 siga al user_2 ???????????
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }

 */
}