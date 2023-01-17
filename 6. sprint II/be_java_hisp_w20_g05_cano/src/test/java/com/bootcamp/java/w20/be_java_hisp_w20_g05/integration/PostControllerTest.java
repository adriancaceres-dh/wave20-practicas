package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("US0005: Create new post")
    public void newPostIntegrationTest() throws Exception {
        // Creamos los DTO y la respuesta esperada
        PostRequestDTO postRequestDTO = TestUtils.getPostRequestDTOForIntegrationTest(16, 99);
        String expectedResponse = TestUtils.getExpectedResponseUS0005ForIntegrationTest();

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String postJson = writer.writeValueAsString(postRequestDTO);

        //Hacemos la request al endpoint
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos
        
        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }

}
