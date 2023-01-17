package com.socialMeli.be_java_hisp_w20_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.UserRepository;
import com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.Charset;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIntegration {

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
    @DisplayName("TI-0001 Camino Feliz")
    void addFollowerOk() throws Exception {
        int userIdToFollow = 234;
        int userId = 123;
        User user = UserUtils.buildUserWithOneFollower(userIdToFollow, 251);

        String response = "Comenzaste a seguir al usuario: " + user.getUserName();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    @DisplayName("TI-0001 Mensaje de excepción cuando el usuario no existe")
    void addFollowerThrowExceptionMessage() throws Exception {
        int userIdToFollow = 4698;
        int userId = 465;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(jsonPath("$").value("El usuario ingresado no existe"));
    }

    @Test
    @DisplayName("TI-0002 Camino Feliz")
    void getFollowerCountOk() throws Exception {
        int userId = 6631;
        UserFollowerCountDTO userFollowerCountDTO = new UserFollowerCountDTO(6631, "usuario2", 2);
        String response = writer.writeValueAsString(userFollowerCountDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    @DisplayName("TI-0002 Mensaje de excepción cuando el usuario no existe")
    void getFollowerCountThrowExceptionMessage() throws Exception {
        int userId = 465;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(jsonPath("$").value("El usuario ingresado no existe."));
    }

    @Test
    @DisplayName("TI-0004 Camino Feliz")
    void unfollowOk() throws Exception {
        int userIdToUnfollow = 234;
        int userId = 4698;
        User user = UserUtils.buildUserWithOneFollower(userIdToUnfollow, 251);

        String response = "Dejaste de seguir al usuario: " + user.getUserName();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

}
