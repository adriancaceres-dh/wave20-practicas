package com.bootcamp.be_java_hisp_w20_g6_villamizar.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0002 - TI0001, Verificar cantidad de usuarios seguidos ")
    void countFollowers() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value("2"));
    }

    @Test
    @DisplayName("US0003 - TI0002, Verificar lista de usuarios seguidores ")
    void listFollowers() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers", hasSize(2)));

    }

    @Test
    @DisplayName("US0004 - TI0003, Verificar lista de usuarios seguidos ")
    void listFollowed() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed", hasSize(1)));
    }
}