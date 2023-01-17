package com.socialmeli.be_java_hisp_w20_g8.controllers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("TI-04")
    public void testSellerCountController() throws Exception{
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",9))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zxc")).andReturn();

    }


    @Test
    @DisplayName("TI-05")
    public void testSellerListController() throws Exception{
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",9))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("zxc")).andReturn();

    }

}
