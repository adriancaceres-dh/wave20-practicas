package com.bootcamp.be_java_hisp_w20_g2.integration;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest;
import com.bootcamp.be_java_hisp_w20_g2.utils.LoadExampleData;
import com.bootcamp.be_java_hisp_w20_g2.utils.mapper.PostMapper;
import com.bootcamp.be_java_hisp_w20_g2.utils.sort.PostStreamSorter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import static com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest.addPostsToUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private final ObjectWriter writer;
    private final IUserRepository userRepository;
    private final LoadExampleData dataLoader;
    private final PostMapper postMapper;

    @Autowired
    public PostIntegrationTest(IUserRepository userRepository, LoadExampleData dataLoader, PostMapper postMapper) {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        this.userRepository = userRepository;
        this.dataLoader = dataLoader;
        this.postMapper = postMapper;
    }

    @Test
    public void addNewProductFailsInvalidUserId() throws Exception {
        PostDTO postDTO = UtilsTest.generatePostDTO(5000);
        String payload = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("The given userId not exist."));

    }

    @Test
    void sendLastPostOfFollowed() throws Exception {
        //Arrange
        User user2 = generateAndSaveUser("Mariano");
        addPostsToUser(user2);
        userRepository.save(user2);

        User user1 = generateAndSaveUser("Pepe");
        user1.follow(user2);
        userRepository.save(user1);

        PostResponseDTO expectedResponseObject = new PostResponseDTO(user1.getId());

        user2.getPosts().stream()
                .sorted(PostStreamSorter.getSortCriteria("date_desc"))
                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .forEach(post -> expectedResponseObject.addPost(postMapper.toWithIdDTO(post, user2.getId())));

        String expectedResponsePayload = writer.writeValueAsString(expectedResponseObject);

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", user1.getId())
                                .param("order", "date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedResponsePayload, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void sendLastPostOfFollowedFailsWithInvalidOrder() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                                .param("order", "invalid_order"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Invalid Post sort criteria"));
    }

    private User generateAndSaveUser() {
        return userRepository.save(new User("John"));
    }


    private User generateAndSaveUser(String name) {
        return userRepository.save(new User(name));
    }

    @Test
    void addNewProductOK() throws Exception {
        User user1 = generateAndSaveUser();
        PostDTO postDTO = UtilsTest.generatePostDTO(user1.getId());
        String payload = writer.writeValueAsString(postDTO);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(payload, result.getResponse().getContentAsString(StandardCharsets.UTF_8));


    }

    @Test
    public void addNewProductFailsInvalidPayloadPost() throws Exception {
        User user1 = generateAndSaveUser();
        PostDTO postDTO = UtilsTest.generatePostDTOWithNegativePrice(user1.getId());
        String payload = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("El precio debe ser mayor a cero"));

    }

    @Test
    public void addNewProductFailsInvalidPayloadProduct() throws Exception {
        User user1 = generateAndSaveUser();
        PostDTO postDTO = UtilsTest.generatePostDTOWithUnnamedProduct(user1.getId());
        String payload = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("El campo no puede estar vacío."));

    }

    @Test
    public void addNewProductFailsInvalidCategory() throws Exception {
        User user1 = generateAndSaveUser();
        PostDTO postDTO = UtilsTest.generatePostDTOWithInvalidCategory(user1.getId());
        String payload = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Invalid category code"));

    }
}