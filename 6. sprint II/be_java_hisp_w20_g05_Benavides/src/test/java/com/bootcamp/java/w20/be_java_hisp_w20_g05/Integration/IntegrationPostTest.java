package com.bootcamp.java.w20.be_java_hisp_w20_g05.Integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationPostTest {
    @Autowired
    MockMvc mockMvc;

    static Set<Post> posts;

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
        posts = TestUtils.createMockPosts();
    }

    @Test
    @DisplayName("01 - New Post With Valid Data")
    public void newPostWithValidData() throws Exception{
        //arrange
        Post post = posts.stream().findFirst().get();
        post.setId(40); //Using post.json to build database, the next instance of a post should be id = 40;

        PostRequestDTO postRequestDTO = mapper.map(post, PostRequestDTO.class);
        PostResponseDTO postResponseDTO = mapper.map(post, PostResponseDTO.class);

        String postResponseJson = writer.writeValueAsString(postResponseDTO);
        String postRequestJson = writer.writeValueAsString(postRequestDTO);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
        //assert
        assertEquals(postResponseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("02 - Get Followed User Posts")
    public void getFollowedUserPostsTest() throws Exception{
        /*
        //arrange
        int userId = 3;
        Set<Post> userPosts = TestUtils.createMockPosts().stream()
                .filter(post -> post.getUserId() == userId).collect(Collectors.toSet());
        List<PostResponseDTO> userPostsResponseDTO = new ArrayList<>();
        userPosts.forEach(post -> userPostsResponseDTO.add(mapper.map(post, PostResponseDTO.class)));
        FollowedUsersPostsResponseDTO followedUsersPostsResponseDTO =
                new FollowedUsersPostsResponseDTO(userId, userPostsResponseDTO);
        String payloadDTO = writer.writeValueAsString(followedUsersPostsResponseDTO);
        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/followed/" + userId + "/list"))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
        //assert
        assertNotEquals(payloadDTO, mvcResult.getResponse().getContentAsString());
         */
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/followed/3/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(3))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
