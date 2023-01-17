package com.bootcamp.be_java_hisp_w20_g1.integration;

import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static private void setWriter(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("T9: Devuelve lista de publicaciones de las ultimas dos semanas de los usuarios seguidos " )
    public void givenValidtUserId_GetLastTwoWeeksPostFromUsers_ShouldReturnSucess() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/2/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").exists())
                .andReturn();

       System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T9: GetLastTwoWeeksPostFromUsers devuelve excepcion si id no existe" )
    public void givenInvalidUserId_GetLastTwoWeeksPostFromUsers_ShouldReturnNotFound() throws Exception {
        String expectedErrorMessage = "El usuario no existe";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/99/list").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedErrorMessage))
                .andReturn();
           System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("T10: Se devuelve post creado si el post es valido" )
    public void givenValidPost_AddPost_ShouldReturnAddedPost() throws Exception {
        PostRequestDto postRequestDto = TestUtil.getPostRequestDTO();
        String jsonPostRequestDto = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(jsonPostRequestDto))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.post_id").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(99))
                .andReturn();
    }

    @Test
    @DisplayName("T10: Se devuelve excepcion si request contiene campos faltantes" )
    public void givenInvalidRequest_AddPost_ShouldThrowException() throws Exception {

    PostRequestDto invalidPostRequestDto = TestUtil.getPostRequestDTO();
    invalidPostRequestDto.setProduct(null);

    String jsonRequest= writer.writeValueAsString(invalidPostRequestDto);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRequest))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();

    System.out.println(mvcResult);
    }
}
