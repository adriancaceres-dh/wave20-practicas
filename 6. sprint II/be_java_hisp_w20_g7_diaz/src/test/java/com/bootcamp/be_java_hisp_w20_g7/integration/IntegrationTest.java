package com.bootcamp.be_java_hisp_w20_g7.integration;

import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @Test
    @DisplayName("Follow Ok")
    void followOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,8)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("User has been followed succesfully"))
                .andReturn();
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @Test
    @DisplayName("Count followers Ok")
    void countFollowersOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(2))
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @Test
    @DisplayName("Find all followers Ok")
    void findAllFollowersOk() throws Exception {

        UserFollowersDto userFollowersDto = new UserFollowersDto(3, "Soraya",new ArrayList<>(List.of(
                new UserDto(1,"Sebastian"),
                new UserDto(2,"Manuel"),
                new UserDto(8,"Juan"),
                new UserDto(4,"Ronald")
        )));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String answerExpected = writer.writeValueAsString(userFollowersDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(answerExpected,mvcResult.getResponse().getContentAsString());
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //US 0008: Ordenamiento alfabético ascendente y descendente
    @Test
    @DisplayName("Find user followed list Ok")
    void findUserFollowedListOk() throws Exception {

        UserFollowedDto userFollowedDto = new UserFollowedDto(4, "Ronald",new ArrayList<>(List.of(
                new UserDto(3,"Soraya")
        )));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String answerExpected = writer.writeValueAsString(userFollowedDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(answerExpected,mvcResult.getResponse().getContentAsString());
    }

    //US 0005: Dar de alta una nueva publicación
    @Test
    @DisplayName("Post Add Ok")
    void postAddOk() throws Exception {

        ProductDto productDto = new ProductDto(3,"Silla Gamer","Gamer","Racer","Red & Black","Special");
        PostCreateDto postCreateDto = new PostCreateDto(3, LocalDate.parse("2021-04-29"),productDto,100,500.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer();

        String payloadDto = writer.writeValueAsString(postCreateDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("Post registered successfully"))
                .andReturn();
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @Test
    @DisplayName("Unfollow Ok")
    void unfollowOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("the user was unfollowed successfully"))
                .andReturn();
    }







}
