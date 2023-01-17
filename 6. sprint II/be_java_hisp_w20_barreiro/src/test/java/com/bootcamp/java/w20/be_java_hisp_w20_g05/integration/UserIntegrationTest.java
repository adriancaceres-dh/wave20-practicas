package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IUserService userService;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    /*
    Usuario válido sigue a otro usuario válido, al cual no seguía anteriormente.
    Se verifica que la respuesta sea correcta, y que la lista de seguidores y seguidos de estos usuarios se vean modificados de forma acorde.
     */
    @Test
    public void followValidUserTest() throws Exception {
        User user1 = userService.getById(1);
        User user2 = userService.getById(2);
        Set<Integer> user1Following = user1.getFollowing();
        Set<Integer> user2Followers = user2.getFollowers();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(user2.getId()))
                .andExpect(jsonPath("$.user_name").value(user2.getUserName()));

        user1Following.add(2);
        user2Followers.add(1);
        assertTrue(CollectionUtils.isEqualCollection(user1.getFollowing(), user1Following));
        assertTrue(CollectionUtils.isEqualCollection(user2.getFollowers(), user2Followers));
    }

    /*
    Usuario válido deja de seguir a otro usuario válido, al cual seguía anteriormente.
    Se verifica que la respuesta sea correcta, y que la lista de seguidores y seguidos de estos usuarios se vean modificados de forma acorde.
     */
    @Test
    public void unfollowValidUserTest() throws Exception {
        User user2 = userService.getById(2);
        User user3 = userService.getById(3);
        Set<Integer> user2Following = user2.getFollowing();
        Set<Integer> user3Followers = user3.getFollowers();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/2/unfollow/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(user3.getId()))
                .andExpect(jsonPath("$.user_name").value(user3.getUserName()));

        user2Following.remove(3);
        user3Followers.remove(2);
        assertTrue(CollectionUtils.isEqualCollection(user2.getFollowing(), user2Following));
        assertTrue(CollectionUtils.isEqualCollection(user3.getFollowers(), user3Followers));
    }

    /*
    Se verifica que la cantidad de seguidores del usuario 2 sea correcta (2 seguidores: el 3 y el 4)
     */
    @Test
    public void getFollowersCountTest() throws Exception{
        User user2 = userService.getById(2);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/2/followers/count"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("user_id").value(user2.getId()))
                .andExpect(jsonPath("followers_count").value(user2.getFollowers().size()))
                .andExpect(jsonPath("user_name").value(user2.getUserName()));
    }

    /*
    Se verifica que la lista de seguidos del usuario 2 sea correcta (2 seguidos: el 3 y el 4)
     */
    @Test
    public void getFollowedListTest() throws Exception{
        User user2 = userService.getById(2);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/2/followed/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("user_id").value(user2.getId()))
                .andExpect(jsonPath("user_name").value(user2.getUserName()))
                .andReturn();

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        FollowedListDTO followedList = new FollowedListDTO(user2.getId(), user2.getUserName());
        user2.getFollowing().forEach(i -> {
            UserResponseDTO userRes = mapper.map(userService.getById(i), UserResponseDTO.class);
            followedList.getFollowed().add(userRes);
        });

        assertEquals(writer.writeValueAsString(followedList), mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /*
    Se verifica que la lista de seguidores del usuario 2 sea correcta (2 seguidores: el 3 y el 4)
     */
    @Test
    public void getFollowersListTest() throws Exception{
        User user2 = userService.getById(2);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/2/followers/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("user_id").value(user2.getId()))
                .andExpect(jsonPath("user_name").value(user2.getUserName()))
                .andReturn();

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        FollowersBySellerDTO followersList = new FollowersBySellerDTO(user2.getId(), user2.getUserName(), new ArrayList<>());
        user2.getFollowers().forEach(i -> {
            UserResponseDTO userRes = mapper.map(userService.getById(i), UserResponseDTO.class);
            followersList.getFollowers().add(userRes);
        });

        assertEquals(writer.writeValueAsString(followersList), mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
