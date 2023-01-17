package com.bootcamp.java.w20.be_java_hisp_w20_g05.Integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.PostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import static org.junit.jupiter.api.Assertions.*;

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

import java.text.SimpleDateFormat;
import java.util.Set;

import static org.springframework.web.servlet.function.ServerResponse.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationPostTest {
    @Autowired
    MockMvc mockMvc;

    static PostRepository postRepository = new PostRepository();

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
        Post post = posts.stream().findFirst().get();
        post.setId(40); //Using post.json to build database, the next instance of a post should be id = 40;

        PostRequestDTO postRequestDTO = mapper.map(post, PostRequestDTO.class);
        PostResponseDTO postResponseDTO = mapper.map(post, PostResponseDTO.class);

        String postResponseJson = writer.writeValueAsString(postResponseDTO);
        String postRequestJson = writer.writeValueAsString(postRequestDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        assertEquals(postResponseJson, mvcResult.getResponse().getContentAsString());
    }

}
