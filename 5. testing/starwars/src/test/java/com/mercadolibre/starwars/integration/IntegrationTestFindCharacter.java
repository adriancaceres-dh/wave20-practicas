package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFindCharacter {
    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;
    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedJson = content().contentType("application/json");
    private CharacterDTO characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }
    @Test
    public void findCharacterTest() throws Exception {
        List<CharacterDTO> expectedList = List.of(characterDTO);
        String expectedListJson = writer.writeValueAsString(expectedList);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedJson)
                .andExpect(expectedStatus)
                .andExpect(content().json(expectedListJson));

    }
}
