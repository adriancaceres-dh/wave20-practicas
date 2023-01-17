package com.socialMeli.be_java_hisp_w20_g03.integration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationUserControllerTests {
    @Autowired
    MockMvc mockMvc;

    @DisplayName("T-0009: Seguir a un usuario")
    @Test
    public void followUser() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollowId}",6932,123)
                                .contentType(MediaType.TEXT_PLAIN))
                                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Comenzaste a seguir al usuario: usuario7"));

    }

    @DisplayName("T-0009: Seguir a un usuario que ya seguias")
    @Test
    public void followUserAlreadyFollowed() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollowId}",6932,123)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Ya estas siguiendo al usuario: usuario7"));

    }

    @DisplayName("T-0009: Seguir a un usuario que no existe")
    @Test
    public void followUserDoesntExists() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollowId}",4698,465)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El usuario ingresado no existe"));

    }

    @DisplayName("T-0010: Obtener cantidad de seguidores")
    @Test
    public void getFollowersCount() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",234)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers. jsonPath("$.followers_count").value(3))
                .andExpect(MockMvcResultMatchers. jsonPath("$.user_id").value(234))
                .andExpect(MockMvcResultMatchers. jsonPath("$.user_name").value("usuario1"));

    }

    @DisplayName("T-0010: Obtener cantidad de seguidores userId no existe")
    @Test
    public void getFollowersCountUserDoesntExists() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",465)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El usuario ingresado no existe."));

    }

    @DisplayName("T-0011: Dejar de seguir a un usuario")
    @Test
    public void unfollowUser() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userToUnfollowId}",4698,234)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Dejaste de seguir al usuario: usuario1"));

    }

    @DisplayName("T-0011: Dejar de seguir a un usuario que no seguia")
    @Test
    public void unfollowUserThatDoesntFollows() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userToUnfollowId}",4698,1536)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("No esta siguiendo a usuario4"));

    }

    @DisplayName("T-0011: Dejar de seguir a un usuario que no existe")
    @Test
    public void unfollowUserThatDoesntExists() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userToUnfollowId}",4698,234432)
                        .contentType(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("El usuario ingresado no existe"));

    }
}
