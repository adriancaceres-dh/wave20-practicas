package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
@Autowired
private MockMvc mockMvc;
    @Test
    void follow() throws  Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("rodri"))
                .andReturn();
    }
    @Test
    void followException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 10,20))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").doesNotExist())
                .andReturn();
    }

    @Test
    void followersCount() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }
    @Test
    void followersCountException() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",99))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    void followersCountNullException() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",""))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").doesNotExist())
                .andReturn();
    }

    @Test
    void followers() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }
    @Test
    void followersException() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 99))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void followed() throws Exception{
      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andReturn();

    }

    @Test
    void unfollow() throws  Exception{
        ListedUserDTO listedUser = new ListedUserDTO(2,"ivan");
        UserFollowedDTO expected = new UserFollowedDTO(1,"rodri", Arrays.asList(listedUser));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(expected);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto) )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andReturn();
    }
  @Test
    void unfollowException() throws Exception{
      this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",2,1))
              .andDo(print()).andExpect(status().isBadRequest())
              .andExpect(content().contentType("application/json"))
              .andExpect(MockMvcResultMatchers.jsonPath("$.followed").doesNotExist())
              .andReturn();
  }

}