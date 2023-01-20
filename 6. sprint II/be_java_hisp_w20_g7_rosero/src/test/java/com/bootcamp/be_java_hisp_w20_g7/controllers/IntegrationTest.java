package com.bootcamp.be_java_hisp_w20_g7.controllers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testFollowOutputOK() throws Exception {
        // Respuesta satisfactoria al hacer Follow correctamente
        String expectResult = "User has been followed succesfully";


        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{id}/follow/{idToFollow}", 3, 4))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$").value("User has been followed succesfully"))
                        .andReturn();

        Assertions.assertEquals(expectResult, mvcResult.getResponse().getContentAsString());

    }
}