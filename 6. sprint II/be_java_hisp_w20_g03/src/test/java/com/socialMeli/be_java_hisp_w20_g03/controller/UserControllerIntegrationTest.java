package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Ver lista de 'Seguidos' Ok ")
    void getFollowedListTest()throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1536)
                .param("order", "name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("followed", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(1536))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("usuario4"));
    }

    @Test
    @DisplayName("Seguir a un usuario OK")
    void followUserTestOK() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 6932,123))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Comenzaste a seguir al usuario: usuario7"));
    }

    @Test
    @DisplayName("Seguir a un usuario- 'Usuario inexistente'")
    void followUserNotFoundTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 4698,465))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(MockMvcResultMatchers.content().string("El usuario ingresado no existe"));
    }

    @Test
    @DisplayName("Cantidad de usuarios que siguen un vendedor OK")
    void followersCountTestOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 234))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("followers_count").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(234))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("usuario1"));
    }

    @Test
    @DisplayName("US-0002 -> Cantidad de usuarios que siguen a un vendedor - Usuario no encontrado")
    void followersCountUserNotFoundTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(MockMvcResultMatchers.content().string("El usuario ingresado no existe."));
    }

    @Test
    @DisplayName("US003 - ¿Quién me sigue? OK")
    void getFollowersListTestOK() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 234))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("followers", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(234))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("usuario1"));
    }

    @Test
    @DisplayName("US003 - ¿Quien me sigue? - Usuario no encontrado")
    void getFollowersListOfNonExistentUser() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1323))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(MockMvcResultMatchers.content().string("El usuario ingresado no existe."));
    }

}
