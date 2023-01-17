package com.bootcamp.be_java_hisp_w20_g4.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
@Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test para verificar el correcto funcionamiento de seguir a un vendedor")
    void follow() throws Exception {

    }

    @Test
    @DisplayName("Test para verificar la cantidad de seguidores de un vendedor")
    void followersCount() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0));
    }

    @Test
    void followers() {
    }

    @Test
    void followed() {
    }

    @Test
    void unfollow() {
    }
}