package com.bootcamp.java.w20.be_java_hisp_w20_g05.Integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationUserTest {
    @Autowired
    MockMvc mockMvc;

    static Set<User> users;

    private static ObjectWriter writer;

    private static ModelMapper mapper;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @BeforeAll
    public static void beforeEach() {
        users = TestUtils.createMockUsers();
    }

    @Test
    @DisplayName("01 - Follow User")
    public void followUserTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("hbowstead0"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("02 - Unfollow User")
    public void unfollowUserTest() throws Exception{
        //Be following to unfollow
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"));

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/1/unfollow/2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("hbowstead0"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("03 - Get Followers Count")
    public void getFollowersCountTest() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/3/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("followers_count").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("qropcke1"))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("04 - Get Followed By Id")
    public void getFollowedByIdTest() throws Exception{
        //Si sobra tiempo, armar arrange con datos

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/2/followed/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("hbowstead0"))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("05 - Get Followers By Seller DTO")
    public void getFollowersBySellerDTOTest() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/4/followers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(4))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
