package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Mock
    private IUserService userSerivce;
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void followAnUserExistingInTheDataBase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andReturn();
    }
    @Test
    void followYourselfAnUserExistingInTheDataBase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("No puedes seguirte a ti mismo"))
                .andReturn();
    }
    @Test
    void followAnUserExistingAlreadyFollowInTheDataBase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Ya esta siguiendo a ese usuario"))
                .andReturn();
    }
    @Test
    void followAnUserNotExistingInTheDataBase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",5,3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Alguno de los usuarios no existe"))
                .andReturn();
    }

    @Test
    void followAnUserExistingInTheDataBaseButAlreadyFollowing() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Ya esta siguiendo a ese usuario"))
                .andReturn();
    }

    @Test
    void countFollowersExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Flavio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2))
                .andReturn();
    }
    @Test
    void countFollowersNotExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("El usuario no existe"))
                .andReturn();
    }

    @Test
    void getFollowersByIdOfUserExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Flavio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Diego"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_name").value("Ale"))
                .andReturn();
    }
    @Test
    void getFollowersByIdOfUserNotExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"))
                .andReturn();
    }

    @Test
    void getFollowedByIdOfUserExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Diego"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("Flavio"))
                .andReturn();
    }
    @Test
    void getFollowedByIdOfUserNotExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"))
                .andReturn();
    }

    @Test
    void unfollowOfUserExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Operación exitosa"))
                .andReturn();
    }
    @Test
    void unfollowOfUserNotExistingInDataBase() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",6,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("User not found"))
                .andReturn();
    }
    @Test
    void unfollowOfUserExistingInDataBaseButNotAlreadyFollow() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Users no longer follow each other"))
                .andReturn();
    }
    @Test
    void unfollowYourselfOfUserExistingInDataBaseBut() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("You can't unfollow yourself"))
                .andReturn();
    }
}