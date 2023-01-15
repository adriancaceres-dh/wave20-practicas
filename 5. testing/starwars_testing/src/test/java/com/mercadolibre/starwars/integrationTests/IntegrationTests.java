package com.mercadolibre.starwars.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    public MockMvc mockMvc;

    private static ObjectWriter objectWriter;

    @BeforeAll
    static void setUp(){
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }



    @Test
    public void MustReturnACorretJson() throws Exception{
        //Arrange

        List<CharacterDTO> characterList = new ArrayList<>();
        characterList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        characterList.add(new CharacterDTO("Luminara Unduli","black","yellow","blue","58BBY","female","Mirial","Mirialan",170,56));

        String expectedJson = objectWriter.writeValueAsString(characterList);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}","lu"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertEquals(expectedJson,result.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource("testLists")
    public void MustReturnCorrectJsons(String searchParam, List<CharacterDTO> characterDTOs) throws Exception{
        //Arrange



        String expectedJson = objectWriter.writeValueAsString(characterDTOs);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}",searchParam))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson,result.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    private static Stream<Arguments> testLists() {

        List<CharacterDTO> result1 = new ArrayList<>();
        result1.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        result1.add(new CharacterDTO("Luminara Unduli","black","yellow","blue","58BBY","female","Mirial","Mirialan",170,56));

        List<CharacterDTO> result2 = new ArrayList<>();
        result2.add(new CharacterDTO("Darth Vader","none","white","yellow","41.9BBY","male","Tatooine","Human",202,136));
        result2.add(new CharacterDTO("Biggs Darklighter","black","light","brown","24BBY","male","Tatooine","Human",183,84));
        result2.add(new CharacterDTO("Darth Maul","none","red","yellow","54BBY","male","Dathomir","Zabrak",175,80));

        List<CharacterDTO> result3 = new ArrayList<>();

        return Stream.of(
                arguments("lu", result1),
                arguments("dar",result2),
                arguments("ross", result3)
        );
    }
}
