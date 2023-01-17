package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;


import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    @DisplayName("US0008: Followed list in ascending order")
    public void getFollowedByIdNameAscOutputTest () throws Exception {
        // Creamos el DTO para comparar con la respuesta
        FollowedListDTO followedListDTO = TestUtils.getFollowedListDTOForIntegrationTest("name_asc");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(followedListDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "2").param("order", "name_asc"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US0008: Followed list in descending order")
    public void getFollowedByIdNameDescOutputTest () throws Exception {
        // Creamos el DTO para comparar con la respuesta
        FollowedListDTO followedListDTO = TestUtils.getFollowedListDTOForIntegrationTest("name_desc");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(followedListDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "2").param("order", "name_desc"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US0008: Followers list in ascending order")
    public void getFollowersByIdNameAscOutputTest () throws Exception {
        // Creamos el DTO para comparar con la respuesta
        FollowersBySellerDTO followersBySellerDTO = TestUtils.getFollowersBySellerDTOForIntegrationTest("name_asc");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(followersBySellerDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "2").param("order", "name_asc"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US0008: Followers list in descending order")
    public void getFollowersByIdNameDescOutputTest () throws Exception {
        // Creamos el DTO para comparar con la respuesta
        FollowersBySellerDTO followersBySellerDTO = TestUtils.getFollowersBySellerDTOForIntegrationTest("name_desc");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(followersBySellerDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "2").param("order", "name_desc"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US0002: Cantidad de seguidores")
    public void getFollowersCountIntegrationTest () throws Exception {
        // Creamos el DTO para comparar con la respuesta
        FollowersCountDTO followersCountDTO = new FollowersCountDTO(2, 2, "hbowstead0");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(followersCountDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "2"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US0001: Follow user")
    public void followUserIntegrationTest() throws Exception {
        // Creamos el DTO para comparar con la respuesta
        UserResponseDTO userResponseDTO = new UserResponseDTO(7, "dbrandli5");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(userResponseDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "6", "7"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US0007: Unfollow user")
    public void unfollowUserIntegrationTest() throws Exception {
        // Creamos el DTO para comparar con la respuesta
        UserResponseDTO userResponseDTO = new UserResponseDTO(5, "cpollastrone3");

        // Convertimos el DTO a json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(userResponseDTO);

        //Hacemos la request al endpoint
        MvcResult actualResponse = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", "6", "5"))
                .andDo( print() ).andExpect(status().isOk()) //Verificamos que devuelva ok
                .andExpect( content().contentType("application/json")) // Que la response sea json
                .andReturn(); // y la guardamos

        // Comparamos la respuesta del endpoint con la que esperamos
        Assertions.assertEquals(expectedResponse, actualResponse.getResponse().getContentAsString());
    }

}
