package com.bootcamp.be_java_hisp_w20_g1_hoffman.integracion;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.User;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ModelMapper mapper = new ModelMapper();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void getFollowersCount(int id) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", id)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).
                andReturn();
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void getUserFollwed(int id) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", id)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).
                andReturn();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void getSellerFollwers(int id) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", id)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).
                andReturn();
    }

    @ParameterizedTest
    @MethodSource("loadDataForFollow")
    void followUser(int id, int idToFollow) throws Exception {
        TestUtil.loadData();
        Set<User> users = TestUtil.getUsers();
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findAny();

         this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", id, idToFollow)).
                 andDo(print()).
                 andExpect(status().isOk()).
                 andExpect(content().contentType("application/json")).
                 andExpect(jsonPath("$.followed").isArray()).
                 andExpect(jsonPath("$.followed", hasSize(user.get().getFollowed().size() + 1))). //la lista de "seguidos" aumenta en 1.
                 andReturn();

    }

    @ParameterizedTest
    @MethodSource("loadDataForUnfollow")
    void unfollowUser(int id, int idToUnfollow) throws Exception {
        TestUtil.loadData();
        Set<User> users = TestUtil.getUsers();
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findAny();
        int followed = user.get().getFollowed().size();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", id, idToUnfollow)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).
                andExpect(jsonPath("$.followed").isArray()).
                andExpect(jsonPath("$.followed", hasSize(followed - 1))). //la lista de "seguidos" disminuye en 1.
                andReturn();

    }

    private static Stream<Arguments> loadDataForFollow() {
        return Stream.of(
                Arguments.of(3, 4),
                Arguments.of(4, 5));

    }

    private static Stream<Arguments> loadDataForUnfollow() {
        return Stream.of(
                Arguments.of(1, 3));


    }
}
