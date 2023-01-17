package com.socialmeli.be_java_hisp_w20_g8.controllers.sellers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SellerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("TI-Count followers by id user")
    void countFollowersByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 5))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(5))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Count followers by id user invalid")
    void findAllPostByIdUserInvalidTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist id"))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Find seller followers by id user")
    void getSellerFollowersByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.seller_id").value(5))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Find seller followers by id user invalid")
    void getSellerFollowersByIdUserInvalidTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist seller"))
                .andReturn();
    }

}
