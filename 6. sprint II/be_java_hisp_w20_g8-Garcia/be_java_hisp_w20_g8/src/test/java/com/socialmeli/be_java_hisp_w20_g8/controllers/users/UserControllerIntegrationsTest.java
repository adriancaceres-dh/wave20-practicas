package com.socialmeli.be_java_hisp_w20_g8.controllers.users;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationsTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("TI-Find followed by id user")
    void getFollowedByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andReturn();
    }
    @Test
    @DisplayName("TI-Find followed by id user invalid")
    void getFollowedByIdUserInvalidTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 60))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Invalid user please check information."))
                .andReturn();
    }
    @Test
    @DisplayName("TI-Find followed by id user is cero")
    void getFollowedByIdUserIsCeroTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 0))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id debe ser mayor a cero"))
                .andReturn();
    }

    @Test
    @DisplayName("TI-New follow")
    void createNewFollowTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{userIdToFollow}", 1, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-New follow user id cero")
    void createNewFollowUserIdCeroTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{userIdToFollow}", 0, 5))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id debe ser mayor a cero"))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-New follow user id to follow cero")
    void createNewFollowUserIdToFollowCeroTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{userIdToFollow}", 1, 0))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id debe ser mayor a cero"))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-Unfollow follow")
    void unFollowTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-Unfollow user id cero")
    void unFollowUserIdCeroTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 0, 5))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id debe ser mayor a cero"))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-Unfollow user id to follow cero")
    void unFollowUserIdToFollowCeroTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 0))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El id debe ser mayor a cero"))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

}
