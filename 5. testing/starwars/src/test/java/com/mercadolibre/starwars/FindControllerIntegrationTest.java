package com.mercadolibre.starwars;

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
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get list of Characters who have 'Lars' in its name")
    public void findCharactersNamedLarsIntegrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Lars"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Owen Lars"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    @DisplayName("Query throws error with empty String")
    public void findEmptyQueryErrorIntegrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", ""))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("No character is retrieved when passing a non existing name")
    public void findCharactersNonExistentNameIntegrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "This name has no matches"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }
}
