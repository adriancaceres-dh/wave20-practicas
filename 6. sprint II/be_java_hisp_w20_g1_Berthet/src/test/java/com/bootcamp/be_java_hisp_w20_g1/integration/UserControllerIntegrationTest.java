package com.bootcamp.be_java_hisp_w20_g1.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T12: Si el id de usuario es valido, devuelve lista de seguidores" )
    public void givenValidId_getUserFollowers_ShouldReturnUserFollowersList() throws Exception {
        Integer validId = 2;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", validId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zmohamedDohamed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").isNotEmpty())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T12: Se devuelve excepcion si el usuario a seguir no existe" )
    public void givenInvalidId_getUserFollowers_ShouldThrowException() throws Exception {
        Integer inexistentId = 99;
        String expectedErrorMessage = "El usuario no existe";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", inexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedErrorMessage))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T13: Se devuelve lista de seguidos si el usuario es valido" )
    public void givenValidId_getUserFollowed_ShouldReturnUserFollowedList() throws Exception {
        Integer validId = 2;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", validId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zmohamedDohamed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").exists())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T13: Se devuelve excepcion si el usuario a consultar lista de seguidos no existe" )
    public void givenInvalidId_getUserFollowed_ShouldThrowException() throws Exception {
        Integer inexistentId = 99;
        String expectedErrorMessage = "El usuario no existe";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", inexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedErrorMessage))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
