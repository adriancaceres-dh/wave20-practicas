package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.service.UserService;
import com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    @DisplayName("Unfollow User OK")
    void unfollowUserOK() throws Exception {
        HashMap<Integer, User> users = UtilsTest.generateUsers();
        User user1 = users.get(1); // user1 follows user1
        User user2 = users.get(2);

        String expectedResponse = "Operación exitosa";

        when(userService.unfollowUser(user1.getId(), user2.getId())).thenReturn((expectedResponse));

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", user1.getId(), user2.getId()))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, response.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Follow User OK")
    void followUserOK() throws Exception {
        HashMap<Integer, User> users = UtilsTest.generateUsers();
        User user1 = users.get(1); // user1 follows user1
        User user2 = users.get(2);

        boolean expectedResponse = true;

        when(userService.follow(user1.getId(), user2.getId())).thenReturn((expectedResponse));

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/follow/{userIdToFollow}", user1.getId(), user2.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andReturn();

        assertEquals(String.valueOf(expectedResponse), response.getResponse().getContentAsString());
    }
}