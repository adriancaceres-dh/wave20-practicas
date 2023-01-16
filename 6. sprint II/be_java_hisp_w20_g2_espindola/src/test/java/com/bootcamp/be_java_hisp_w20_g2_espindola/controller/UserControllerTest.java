package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Happy path - It should be able to follow a new user")
    void testFollowUserOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Happy path - It should return the number of followers for a given user Id")
    void testCountFollowersOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.user_name").value("Flavio"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("Happy path - It should return the list of followers for a given user Id, unordered")
    void testGetFollowersByIdOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followers", hasSize(2)))
                .andExpect(jsonPath("$.followers[0].user_name").value("Diego"));
    }

    //hacer las bad request y los de ordenamiento

    @Test
    @DisplayName("Happy path - It should return the list of followed for a given user Id, unordered")
    void testGetFollowedByIdOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Diego"))
                .andExpect(jsonPath("$.followed", hasSize(1)))
                .andExpect(jsonPath("$.followed[0].user_name").value("Flavio"));
    }

    @Test
    @DisplayName("Happy path - It should unfollow a user from a given user Id to another given user Id to unfollow")
    void testUnfollowUserOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Operación exitosa"));
    }
}