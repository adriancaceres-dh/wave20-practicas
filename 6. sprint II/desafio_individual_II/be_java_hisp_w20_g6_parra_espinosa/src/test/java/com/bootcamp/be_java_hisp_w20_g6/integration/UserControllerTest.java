package com.bootcamp.be_java_hisp_w20_g6.integration;

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
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void testFollowUser()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    void testFollowSameUserException()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("SameUserException"));
    }
    @Test
    void testFollowUserException()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 9,3))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UserNotFoundException"));
    }
    @Test
    void testFollowersCount() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("pablito1"));
    }
    @Test
    void testFollowedList() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1));
    }
    @Test
    void testFollowedListException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 99))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UserNotFoundException"));
    }
    @Test
    void testFollowersList() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1));
    }
    @Test
    void testFollowersListException() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 99))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UserNotFoundException"));
    }
    @Test
    void testUnfollowException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("FollowerNotFoundException"));

    }
}
