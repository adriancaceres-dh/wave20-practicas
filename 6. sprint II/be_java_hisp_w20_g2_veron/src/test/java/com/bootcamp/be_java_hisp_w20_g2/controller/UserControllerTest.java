package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private IUserRepository userRepository;




    private User loadUser(int id){
        User user = new User("fede");
        user.setId(id);
        userRepository.save(user);

        return user;
    }

    @Test
    void follow() throws Exception {

        loadUser(100);
        loadUser(101);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/follow/{idToFollow}",100,101))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value(true));



    }

    @Test
    void followMySelf() throws Exception{
        loadUser(103);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/follow/{idToFollow}",103,103))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("No puedes seguirte a ti mismo"));;

    }


    @Test
    void followExistingFollowing() throws Exception{
        User user = loadUser(104);
        User userToFollow = loadUser(105);
        user.follow(userToFollow);
        userRepository.save(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/follow/{idToFollow}",104,105))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("Ya esta siguiendo a ese usuario"));

    }

    @Test
    void followNullUser() throws Exception {
        loadUser(106);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/follow/{idToFollow}",106,6))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("Alguno de los usuarios no existe"));;
    }




    @Test
    void unFollow() throws Exception {

        User user1 = loadUser(100);
        User user2 = loadUser(101);

        user1.follow(user2);
        userRepository.save(user1);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/unfollow/{idToFollow}",100,101))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("Operación exitosa"));



    }

    @Test
    void unFollowNotFollowing() throws Exception {

        loadUser(100);
        loadUser(101);



        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/unfollow/{idToFollow}",100,101))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("Users no longer follow each other"));


    }

    @Test
    void unFollowNullUser() throws Exception {

        loadUser(100);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/unfollow/{idToFollow}",100,101))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("User to unfollow not found"));


    }


    @Test
    void unFollowMySelf() throws Exception {

        loadUser(100);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/unfollow/{idToFollow}",100,100))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$")
                        .value("You can't unfollow yourself"));


    }


    @Test
    void getFollowedList() throws Exception {
        User user1 = loadUser(100);
        User user2 = loadUser(101);
        user2.addFollower(user1);
        user1.follow(user2);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 100).param("order","name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id").value(101));;


    }


    @Test
    void getFollowersList() throws Exception {
        User user1 = loadUser(100);
        User user2 = loadUser(101);
        user1.addFollower(user2);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 100).param("order","name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(101));


    }



    @Test
    void getFollowedListNotValid() throws Exception {
        loadUser(100);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 100).param("order","bad"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("Invalid User sort criteria"));
    }

    @Test
    void getFollowersListNotValid() throws Exception {
        loadUser(100);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 100).param("order","bad"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("Invalid User sort criteria"));
    }

}