package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get list of Characters who has 'Luke' in its name")
    public void getCharactersWithLukeName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("Get list of Characters who has 'Darth' in its name")
    public void getCharactersWithDarthName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Darth Vader"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Darth Maul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("No character is retrieved when passing a non existing name")
    public void getNoCharactersWhenNameIsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "THIS-DOES-NOT-EXIST"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }


}