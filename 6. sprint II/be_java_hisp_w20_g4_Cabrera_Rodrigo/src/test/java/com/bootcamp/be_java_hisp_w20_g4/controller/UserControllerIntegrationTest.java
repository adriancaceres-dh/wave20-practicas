package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
@Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test para verificar el correcto funcionamiento de seguir a un vendedor")
    void follow() throws Exception {
        int idUser = 1;
        int idToFollow = 3;
        ListedUserDTO listedUserExpected = new ListedUserDTO(3, "emi");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        UserFollowedDTO userFollowedDTOExpecetedResponse = new UserFollowedDTO(1, "rodri", List.of(listedUserExpected));
        String expectedResponse = writer.writeValueAsString(userFollowedDTOExpecetedResponse);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", idUser, idToFollow).contentType(MediaType.APPLICATION_JSON));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedResponse);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", idUser).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);

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