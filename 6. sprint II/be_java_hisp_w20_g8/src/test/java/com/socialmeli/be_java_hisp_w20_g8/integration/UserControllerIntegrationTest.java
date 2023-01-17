package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.ErrorDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper mapper;

    public UserControllerIntegrationTest () {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("T-0011 -> Follow a seller successfully")
    void newFollowOk() throws Exception {
        // arrange
        int userId = 1;
        int sellerId = 7;

        ResponseDTO responseDTO = new ResponseDTO(true, "New Follower add successfully");
        String responseJson = mapper.writeValueAsString(responseDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{sellerId}", userId, sellerId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0011 -> Follow a seller with an invalid user ID")
    void newFollowInvalidUser() throws Exception {
        // arrange
        int userId = 20;
        int sellerId = 7;

        ErrorDTO errorDTO = new ErrorDTO("Not found exception", "Invalid users please check information.");
        String responseJson = mapper.writeValueAsString(errorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{sellerId}", userId, sellerId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0011 -> Follow a seller with an invalid user ID")
    void newFollowInvalidSeller() throws Exception {
        // arrange
        int userId = 1;
        int sellerId = 70;

        ErrorDTO errorDTO = new ErrorDTO("Not found exception", "Invalid users please check information.");
        String responseJson = mapper.writeValueAsString(errorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{sellerId}", userId, sellerId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0011 -> Follow a seller with an invalid user ID")
    void newFollowSameIds() throws Exception {
        // arrange
        int userId = 7;
        int sellerId = 7;

        ErrorDTO errorDTO = new ErrorDTO("Operation failed exception", "A user can't follow himself");
        String responseJson = mapper.writeValueAsString(errorDTO);

        // act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/users/{userId}/follow/{sellerId}", userId, sellerId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}
