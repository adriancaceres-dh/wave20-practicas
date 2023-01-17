package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.controller;


import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.model.User;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil.getSellerUser;
import static com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil.getUserWithFollowed;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Get followed sellers of a valid user")
    public void whenGivenValidUserId_getUserFollowed_shouldReturnUserFollowedResponseDto() throws Exception {
        User user = getUserWithFollowed(false);
        user.setName("zchanelleHhanelle");
        User user1 = getSellerUser("kinaMina", 3);
        User user2 = getSellerUser("zmohamedDohamed", 2);
        UserFollowedResponseDto userFollowedResponseDto = TestUtil.getUserFollowedResponseDto(user, user1, user2);

        String expectedResult = writer.writeValueAsString(userFollowedResponseDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResult, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get followed sellers of an invalid user")
    public void whenGivenInvalidUserId_getUserFollowed_shouldReturnUserFollowedResponseDto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 67))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Parameter.getString("EX_NotExistentUser")))
                .andReturn();
    }
}
