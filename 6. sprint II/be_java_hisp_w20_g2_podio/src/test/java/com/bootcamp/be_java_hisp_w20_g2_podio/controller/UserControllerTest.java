package com.bootcamp.be_java_hisp_w20_g2_podio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFollowOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    public void testFollowUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 999,9999))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Alguno de los usuarios no existe"));
    }

    @Test
    public void testCountFollowersOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.user_name").value("Flavio"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }



}