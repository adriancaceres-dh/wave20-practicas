package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StarwarsIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("IT-01-> Check for query Dark")
    public void checkForCharachtersWithDarkInName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}","dark")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Biggs Darklighter"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].hair_color").value("black"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].skin_color").value("light"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].eye_color").value("brown"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birth_year").value("24BBY"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].homeworld").value("Tatooine"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].height").value(183))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mass").value(84));
    }@Test
    @DisplayName("IT-01-> Check for empty result")
    public void ChackForEmptyResult() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}","234nd8s")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
