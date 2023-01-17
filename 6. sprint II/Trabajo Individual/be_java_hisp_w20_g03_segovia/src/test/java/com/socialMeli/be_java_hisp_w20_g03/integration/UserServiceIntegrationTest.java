package com.socialMeli.be_java_hisp_w20_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.service.IUserService;
import com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    IUserService userService;

    @Test
    void addFollowerTestOk() throws Exception{
         User user = UserUtils.getUserAddFollower(6631);
        String response = "Comenzaste a seguir al usuario: " + user.getUserName();


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(user);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",234,6631)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));

    }
   /* @Test
    void getFollowersListTestOK() throws Exception{
        User user = UserUtils.getUserAddFollower(234);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(user);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list",234)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
               .andReturn();
    }*/


}
