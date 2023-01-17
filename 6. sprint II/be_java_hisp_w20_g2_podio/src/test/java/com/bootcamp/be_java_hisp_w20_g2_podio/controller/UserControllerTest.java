package com.bootcamp.be_java_hisp_w20_g2_podio.controller;

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
    public void testFollowAlreadyFollowing() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Ya esta siguiendo a ese usuario"));
    }

    @Test
    public void testFollowCannotFollowYoursekf() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("No puedes seguirte a ti mismo"));
    }

    @Test
    public void testCountFollowersOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.user_name").value("Flavio"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    public void testCountFollowersUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",999))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El usuario no existe"));
    }

    @Test
    public void testGetFollowersByIdOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followers", hasSize(2)))
                .andExpect(jsonPath("$.followers[0].user_name").value("Diego"));
    }

    @Test
    public void testGetFollowersByIdUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",999))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }

    @Test
    public void testGetFollowedByIdOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followed[0].user_name").value("Flavio"));
    }

    @Test
    public void testGetFollowedByIdUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",999))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }

    @Test
    public void testUnfollowOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1,3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Operación exitosa"));

    }

    @Test
    public void testUnfollowUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 0,999))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("User not found"));

    }

    @Test
    public void testUnfollowCannotUnfollowYourself() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1,1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("You can't unfollow yourself"));

    }

}