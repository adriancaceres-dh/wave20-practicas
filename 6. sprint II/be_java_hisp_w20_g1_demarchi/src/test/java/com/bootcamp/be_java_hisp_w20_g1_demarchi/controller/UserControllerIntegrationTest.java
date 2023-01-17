package com.bootcamp.be_java_hisp_w20_g1_demarchi.controller;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String TIMESTAMP_REGEX = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{6}";

    @Test
    @DisplayName("T9: Se obtiene la cantidad de usuarios que siguen a un usuario")
    public void givenAnIdOfASellerWithFollowers_whenGettingFollowers_thenFollowersResponseIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zmohamedDohamed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(3));
    }

    @Test
    @DisplayName("T9: Se muestra mensaje de error porque el usuario no existe cuando se quiere obtener la cantidad de usuarios que lo siguen ")
    public void givenAnIdOfNonExistentUserId_whenGettingFollowers_thenNonExistentUserMessageIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 999))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Parameter.getString("EX_NotExistentUser")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T9: Se muestra mensaje de error porque el usuario no es vendedor cuando se quiere obtener sus seguidores")
    public void givenAnIdOfANonSellerUserId_whenGettingFollowers_thenNotSellerMessageIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 9))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Parameter.getString("EX_NotASeller")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T10: Se muestra lista de usuarios que siguen a un usuario en particular")
    public void givenAnIdOfASeller_whenGettingHisFollowers_thenUsersAreShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 3))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("kinaMina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("zchanelleHhanelle"));
    }

    @Test
    @DisplayName("T10: Se muestra mensaje de error porque el usuario no es vendedor cuando se quiere obtener lista de seguidores")
    public void givenAnIdOfANonSeller_whenGettingHisFollowers_thenAnErrorMessageIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 6))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Parameter.getString("EX_NotASeller")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T11: Se muestran los vendedor que un usuario sigue")
    public void givenAnId_whenGettingHisFollowedList_thenAnSellersAreShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zchanelleHhanelle"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("kinaMina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("zmohamedDohamed"));
    }

    @Test
    @DisplayName("T11: Se muestra mensaje de error porque se pasa un valor para el query param inválido")
    public void givenAnInvalidQueryParam_whenTryingToGetAnOrderedList_thenAnErrorMessageIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order", "INVALID_ORDER"))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Parameter.getString("EX_InvalidQueryParamValue")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T12: Se puede seguir a un usuario")
    public void givenAnUserId_whenFollowingASeller_thenUserFollowsHim() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 4, 2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("zmohamedDohamed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", hasSize(1)));

    }

    @Test
    @DisplayName("T12: No se puede seguir a un usuario porque no es vendedor")
    public void givenAnUserId_whenFollowingARegularUser_thenAnErrorMessageIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 4, 10))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no es vendedor"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T13: Se puede dejar de seguir a un usuario")
    public void givenAnUserId_whenUnfollowingAnUser_thenUserDoesNotFollowHimAnymore() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 3, 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", hasSize(0)));
    }
}