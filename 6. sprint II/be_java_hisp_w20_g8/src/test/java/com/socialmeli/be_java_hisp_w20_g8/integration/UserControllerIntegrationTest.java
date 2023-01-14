package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T-0001 -> Testing of new follow user endpoint")
    void testNewFollowOK() throws Exception {

        int userId = 1;
        int userIdToFollow = 6;

        ResponseDTO expectedResponseDTO = new ResponseDTO(true, "New Follower add successfully");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseJson = writer.writeValueAsString(expectedResponseDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(expectedResponseJson, mvcResult.getResponse().getContentAsString());


    }

    @Test
    @DisplayName("T-0001 -> Testing of new follow user endpoint but userId doesn't exist ")
    void testNewFollow() throws Exception {

        int userId = 8; //UserId doesn't exist
        int userIdToFollow = 6; //UserIdToFollow exist

        String expectedMessageError = "try to add new follow failed";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedMessageError))
                .andReturn();


    }
    @Test
    @DisplayName("T-0001 -> Testing of new follow user endpoint but userIdToFollow doesn't exist ")
    void testNewFollowNotOKV2() throws Exception {

        int userId = 1; //UserId  exist
        int userIdToFollow = 90; //UserIdToFollow doesn't exist

        String expectedMessageError = "Invalid users please check information.";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(expectedMessageError))
                .andReturn();


    }

    @Test
    @DisplayName("T-0001 -> Checking endpoint validations")
    void TestNewFollowValidations() throws Exception{


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/users/{userId}/follow/{userIdToFollow}", null, userIdToFollow))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));


    }


}