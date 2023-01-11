package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testFindOutput() throws Exception {
        // arrange
        String query = "Luke";
        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                .andReturn();
        // assert
        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void testFindNotFoundOutput() throws Exception {
        // arrange
        String query = "";
        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();
        // assert
        assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    void testFindResponseContentOutput() throws Exception {
        // arrange
        String query = "Luke";
        List<CharacterDTO> characters = List.of(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(characters);
        // act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        // assert
        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }
}
