package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }


    @Test
    void followTest() throws Exception {
        ListedUserDTO listedUser = new ListedUserDTO(2,"ivan");
        UserFollowedDTO expected = new UserFollowedDTO(1,"rodri", Arrays.asList(listedUser));

        ObjectWriter mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","1","2")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(mapper.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followersCountTest() throws Exception {

        UserCountDTO expected = new UserCountDTO(1,"rodri",1);
        ObjectWriter mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        MvcResult follow = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","2","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(mapper.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());
    }

}