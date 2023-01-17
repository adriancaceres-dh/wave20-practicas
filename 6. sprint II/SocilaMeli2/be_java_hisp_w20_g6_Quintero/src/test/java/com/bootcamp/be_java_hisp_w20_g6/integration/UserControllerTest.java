package com.bootcamp.be_java_hisp_w20_g6.integration;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.util.TestsUtilsGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("IT-0001, US-0003 endpoint:/users/{userId}/followers/list. Result Ok")
    void shouldReturnStatusOkFollowersList()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }
    @Test
    @DisplayName("IT-0002, US-0004 endpoint:/users/{userId}/followed/list. Result Ok")
    void shouldReturnStatusOkFollowedList()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    @DisplayName("IT-0003, US-0001  endpoint:/users/{userId}/follow/{userIdToFollow}. HandlerException,")
    void shouldHandlerExceptionNotFollowSameUser() throws Exception {


        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,1)
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();


    }


}
