package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Follow User - It should be able to follow a new user")
    void testFollowUserOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Follow User - It should throw an exception when try to follow an already following user")
    void testFollowUserAlreadyFollowing() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("Ya esta siguiendo a ese usuario"));
    }

    @Test
    @DisplayName("Follow User - It should throw an exception when try to follow yourself")
    void testFollowUserFollowYourself() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("No puedes seguirte a ti mismo"));
    }

    @Test
    @DisplayName("Follow User - It should throw an exception when try to follow with an invalid user id")
    void testFollowUserNotValid() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 555))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("Alguno de los usuarios no existe"));
    }

    @Test
    @DisplayName("Get Followers Count - It should return the number of followers for a given user Id")
    void testCountFollowersOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.user_name").value("Flavio"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("Get Followers Count - It should throw an exception when given an invalid user Id")
    void testCountFollowersBadRequest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 666))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("El usuario no existe"));
    }

    @Test
    @DisplayName("Find All Followers - It should return the list of followers for a given user Id, unordered")
    void testGetFollowersByIdOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followers", hasSize(2)))
                .andExpect(jsonPath("$.followers[0].user_name").value("Diego"));
    }

    @Test
    @DisplayName("Find All Followers - It should throw an exception when given an invalid user Id")
    void testGetFollowersByBadRequest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 555))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException))
                .andExpect(content().string("User not found"));
    }

    @Test
    @DisplayName("Find All Followers - It should return the list of followers for a given user Id, ascendant order")
    void testGetFollowersByIdOrderAsc() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2).param("order","name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followers", hasSize(2)))
                .andExpect(jsonPath("$.followers[1].user_name").value("Diego"))
                .andExpect(jsonPath("$.followers[0].user_name").value("Ale"));
    }

    @Test
    @DisplayName("Find All Followers - It should return the list of followers for a given user Id, descendant order")
    void testGetFollowersByIdOrderDesc() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2).param("order","name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.followers", hasSize(2)))
                .andExpect(jsonPath("$.followers[0].user_name").value("Diego"))
                .andExpect(jsonPath("$.followers[1].user_name").value("Ale"));
    }

    @Test
    @DisplayName("Find All Followers - It should throw an exception when given an invalid order criteria")
    void testGetFollowersByIdOrderNotValid() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2).param("order","anything"))
                .andDo(print()).andExpect(status().isBadRequest())
                //.andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("Invalid User sort criteria"));
    }

    @Test
    @DisplayName("Find All Followed - It should return the list of followed for a given user Id, unordered")
    void testGetFollowedByIdOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Diego"))
                .andExpect(jsonPath("$.followed", hasSize(1)))
                .andExpect(jsonPath("$.followed[0].user_name").value("Flavio"));
    }

    /*
    * Para probar el ordenamiento no contamos con más usuarios generados en los respositorios,
    * el desarrollo de los tests sería, en este caso, el mismo para el visto con los test de Find All followers
    */

    @Test
    @DisplayName("Find All Followed - It should throw an exception when given an invalid user Id")
    void testGetFollowedByBadRequest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 555))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException))
                .andExpect(content().string("User not found"));
    }

    @Test
    @DisplayName("Find All Followed - It should throw an exception when given an invalid order criteria")
    void testGetFollowedByIdOrderNotValid() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2).param("order","anything"))
                .andDo(print()).andExpect(status().isBadRequest())
                //.andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("Invalid User sort criteria"));
    }

    @Test
    @DisplayName("Unfollow User - It should unfollow a user from a given user Id to another given user Id to unfollow")
    void testUnfollowUserOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Operación exitosa"));
    }

    @Test
    @DisplayName("Unfollow User - It should throw an exception when given an invalid user Id")
    void testUnfollowUserBadRequest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 777, 2))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("User not found"));
    }

    @Test
    @DisplayName("Unfollow User - It should throw an exception when given an invalid user Id to unfollow")
    void testUnfollowUserBadRequestII() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 777))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("User to unfollow not found"));
    }

    @Test
    @DisplayName("Unfollow User - It should throw an exception when users are no longer following each other")
    void testUnfollowUserBadRequestIII() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 3))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadRequestException))
                .andExpect(content().string("Users no longer follow each other"));
    }

}