package com.bootcamp.be_java_hisp_w20_g2.integration;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private IUserRepository userRepository;
    private ObjectWriter writer;

    @Autowired
    public UserIntegrationTest(IUserRepository userRepository) {
        this.userRepository = userRepository;
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void followOK() throws Exception {
        User user1 = new User("Fran");
        User user2 = new User("John");
        userRepository.save(user1);
        userRepository.save(user2);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", user1.getId(), user2.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("User followed."));
    }

    @Test
    void unfollowOK() throws Exception {
        User user1 = new User("Fran");
        User user2 = new User("John");
        user2.follow(user1);
        user1.addFollower(user2);
        userRepository.save(user1);
        userRepository.save(user2);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", user2.getId(), user1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Operación exitosa"));
    }

    @Test
    void countFollowersOK() throws Exception {
        User user1 = new User("Fran");
        User user2 = new User("John");
        user2.follow(user1);
        user1.addFollower(user2);
        userRepository.save(user1);
        userRepository.save(user2);

        UserFollowersCountResponseDTO expectedResponseObject =
                new UserFollowersCountResponseDTO(user1.getId(), user1.getUserName(), 1);

        String expectedResponsePayload = writer.writeValueAsString(expectedResponseObject);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/count", user1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedResponsePayload, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void getFollowersOK() throws Exception {
        User user1 = new User("Fran");
        User user2 = new User("John");
        user2.follow(user1);
        user1.addFollower(user2);
        userRepository.save(user1);
        userRepository.save(user2);

        UserFollowersResponseDTO expectedResponseObject = new UserFollowersResponseDTO(
                user1.getId(),
                user1.getUserName(),
                List.of(new UserResponseDTO(user2.getId(), user2.getUserName())));

        String expectedResponsePayload = writer.writeValueAsString(expectedResponseObject);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", user1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedResponsePayload, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void getFollowedOK() throws Exception {
        User user1 = new User("Fran");
        User user2 = new User("John");
        user2.follow(user1);
        user1.addFollower(user2);
        userRepository.save(user1);
        userRepository.save(user2);

        UserFollowedResponseDTO expectedResponseObject = new UserFollowedResponseDTO(
                user2.getId(),
                user2.getUserName(),
                List.of(new UserResponseDTO(user1.getId(), user1.getUserName())));

        String expectedResponsePayload = writer.writeValueAsString(expectedResponseObject);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", user2.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedResponsePayload, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
