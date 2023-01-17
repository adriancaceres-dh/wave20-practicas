package com.socialmeli.be_java_hisp_w20_g8.integration;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import org.junit.jupiter.api.Assertions;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T-0001 -> Add new follower integration test")
    void newFollowPostIntegrationTest() throws Exception {
        int userId = 1;
        int userIdToFollow = 6;

        ResponseDTO responseDTO = new ResponseDTO(true, "New Follower add successfully");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/users/" + userId +
                        "/follow/" + userIdToFollow))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());


    }

    @Test
    @DisplayName("T-0002 -> Unfollow a user integration test")
    void unfollowPostIntegrationTest() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 6;

        ResponseDTO responseDTO = new ResponseDTO(true, "you have unfollowed the user");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId +
                        "/unfollow/" + userIdToUnfollow))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0003 -> List of all vendors followed by a given user integration test")
    void getFollowGetIntegrationTest() throws Exception {
        int userId = 1;
        String order = "date_asc";
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?", userId, order))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("user1")).andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("T-0004 -> Create post integration test")
    void postPostIntegrationTest() throws Exception {
        PostRequestDTO payloadDTO = PostRequestDTO.builder()
                .user_id(6)
                .date(LocalDate.of(2023, 1, 15))
                .productDTO(ProductDTO.builder()
                        .product_id(101)
                        .product_name("Desk")
                        .type("Kazan")
                        .brand("Axis")
                        .color("Black")
                        .notes("Special Edition")
                        .build())
                .category(301)
                .price(389.000)
                .build();
        ResponseDTO responseDTO = ResponseDTO.builder()
                .ok(true)
                .message("Post added successfully")
                .build();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());

    }
}
