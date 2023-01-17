package com.bootcamp.be_java_hisp_w20_g7.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestUserController {

    @Autowired
    MockMvc mockMvc;

    @Test
    void countFollowers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(3))
                .andExpect(jsonPath("$.user_name").value("Soraya"))
                .andExpect(jsonPath("$.followers_count").value(4));
    }

    @Test
    void findAllFollowers() throws Exception {
    }

    @Test
    void findUserFollowedList() throws Exception {
    }
}