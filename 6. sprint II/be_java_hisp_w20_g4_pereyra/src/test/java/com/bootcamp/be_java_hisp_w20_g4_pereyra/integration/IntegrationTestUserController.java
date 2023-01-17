package com.bootcamp.be_java_hisp_w20_g4_pereyra.integration;


import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTestUserController {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración - seguir a un usuario")
    public void followUserTest() throws Exception {
        int idUser = 1;
        int idUserToFollow = 2;

        ListedUserDTO expectedListedUserDTO = new ListedUserDTO(2, "ivan");
        UserFollowedDTO expectedResponseDto = new UserFollowedDTO(1, "rodri", List.of(expectedListedUserDTO));
        String expectedResponse = TestUtils.writer.writeValueAsString(expectedResponseDto);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedResponse);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",idUser,idUserToFollow)
                        .contentType(TestUtils.mediaTypeJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }

    @Test
    @DisplayName("Test de integración - Lista de seguidores de un usuario")
    public void followersUserTest() throws Exception {
        int idUser = 1;
        int idUserToFollow = 2;

        ListedUserDTO expectedListedUserDTO = new ListedUserDTO(1, "rodri");
        UserFollowersDTO expectedResponseDto = new UserFollowersDTO(2, "ivan", List.of(expectedListedUserDTO));
        String expectedResponse = TestUtils.writer.writeValueAsString(expectedResponseDto);

        // el usuario 1 sigue al usuario 2
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",idUser,idUserToFollow)
                .contentType(MediaType.APPLICATION_JSON));
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedResponse);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",idUserToFollow)
                        .contentType(TestUtils.mediaTypeJson))
                .andDo(print()).andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }

    @Test
    @DisplayName("Test de integración para la cantidad de followers de un usuario")
    public void followersCountTest() throws Exception {
        int idUser = 1;
        int idUserToFollow = 3;
        // el usuario 1 sigue al usuario 3
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",idUser,idUserToFollow)
                .contentType(TestUtils.mediaTypeJson));
        UserCountDTO expectedUserCountDTO = new UserCountDTO(idUserToFollow, "emi", 1);
        String expectedResponse = TestUtils.writer.writeValueAsString(expectedUserCountDTO);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedResponse);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{idUserToFollow}/followers/count",idUserToFollow)
                .contentType(TestUtils.mediaTypeJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);

    }

}
