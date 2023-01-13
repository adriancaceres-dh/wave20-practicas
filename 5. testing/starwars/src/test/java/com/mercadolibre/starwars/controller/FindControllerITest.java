package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerITest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFindLuke() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    public void shouldFindDarth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Darth Vader"));
    }
}
