package com.bootcamp.be_java_hisp_w20_g4_pereyra.integration;


import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.utils.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserService {
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
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }




}
