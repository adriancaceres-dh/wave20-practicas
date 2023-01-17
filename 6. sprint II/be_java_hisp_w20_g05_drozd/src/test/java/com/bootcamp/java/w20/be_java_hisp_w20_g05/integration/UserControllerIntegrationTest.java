package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp(){
        writer= new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }
    @Test
    @DisplayName("T-0009 Ok")
    public void getFollowersCountEndpointTestOk() throws Exception{
        int userId=5;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("cpollastrone3"))
                .andExpect(jsonPath("$.followers_count").value(5));
    }
    @Test
    @DisplayName("T-0009 Not_Found_Exception")
    public void getFollowersCountEndpointTestIdNotFoundException() throws Exception{
        int userId=329847;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("User with id: "+userId+" was not found"));
    }
    @Test
    @DisplayName("T-0009 Wrong_Param_Exception")
    public void getFollowersCountEndpointTestWrongParameterException() throws Exception{
        int userId=-1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El Id debe ser mayor a 0."));
    }

    @Test
    @DisplayName("T-0011 FollowedListOk")
    public void getFollowedByIdTestOk() throws Exception{
        int userId=16;
        List<UserResponseDTO> folls =TestUtils.createFollsListDto(userId,true);
        String expected= writer.writeValueAsString(new FollowedListDTO(userId,"rpostlee",folls));

        MvcResult mvcResult= this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String result= mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(expected,result);

    }

    @Test
    @DisplayName("T-0012 FollowersListOk")
    public void getFollowersBySellerDtoTestOk() throws Exception{
        int userId=16;
        List<UserResponseDTO> folls =TestUtils.createFollsListDto(userId,false);
        String expected= writer.writeValueAsString(new FollowersBySellerDTO(userId,"rpostlee",folls));

        MvcResult mvcResult= this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String result= mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals(expected,result);

    }

}

