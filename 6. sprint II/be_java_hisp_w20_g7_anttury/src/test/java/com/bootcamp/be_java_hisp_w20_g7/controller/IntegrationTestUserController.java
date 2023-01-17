package com.bootcamp.be_java_hisp_w20_g7.controller;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.exception.ExceptionDTO;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestUserController {

    @Autowired
    MockMvc mockMvc;

    //T009 Verifica si el usuario existe y devuelve su cantidad de seguidores
    @Test
    void testValidUserCountFollowers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.userId").value(3))
                .andExpect(jsonPath("$.userName").value("Soraya"))
                .andExpect(jsonPath("$.followersCount").value(4));
    }

    //T009 Lanza una excepción si el usuario no existe
    @Test
    void testInvalidUserIdToCountFollowers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 9))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("UserNotFoundException"))
                .andExpect(jsonPath("$.message").value("User Not Found"));
    }

    //T010 Verifica si el usuario existe y devuelve sus seguidores
    @Test
    void testValidUserFollowers() throws Exception {
        UserFollowersDto userFollowersDto = new UserFollowersDto(2, "Manuel",
                new ArrayList<>(List.of(new UserDto(5, "Nathalia"))));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expected = writer.writeValueAsString(userFollowersDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    //T010 Lanza una excepción si el usuario no existe
    @Test
    void testNotValidUserFollowers() throws Exception {
        UserFollowersDto userFollowersDto = new UserFollowersDto(9, "Manuelo",
                new ArrayList<>(List.of(new UserDto(5, "Nathalia"))));

        ExceptionDTO error = new ExceptionDTO("UserNotFoundException", "User Not Found");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(userFollowersDto);
        String expected = writer.writeValueAsString(error);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 9)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    //T011 Verifica si el usuario existe y devuelve sus seguidos
    @Test
    void testValidUserFollowed() throws Exception {
        UserFollowedDto userFollowedDto = new UserFollowedDto(5, "Nathalia",
                new ArrayList<>(List.of(new UserDto(4, "Ronald"), new UserDto(2, "Manuel"))));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expected = writer.writeValueAsString(userFollowedDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    //T011 Lanza una excepción si el usuario no existe
    @Test
    void testNotValidUserFollowed() throws Exception {
        UserFollowedDto userFollowedDto = new UserFollowedDto(9, "Nathalio",
                new ArrayList<>(List.of(new UserDto(6, "Tomas"), new UserDto(2, "Manuel"))));

        ExceptionDTO error = new ExceptionDTO("UserNotFoundException", "User Not Found");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(userFollowedDto);
        String expected = writer.writeValueAsString(error);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 9)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

}