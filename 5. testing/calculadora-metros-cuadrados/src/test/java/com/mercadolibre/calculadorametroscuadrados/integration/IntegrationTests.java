package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.mercadolibre.calculadorametroscuadrados.calculadoraUtilsTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectWriter;

    public IntegrationTests() {
        this.objectWriter =new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }

    @Test
    public void peticionOk() throws Exception{

        HouseDTO houseDTO = calculadoraUtilsTest.utilTestHouseDtos();
        HouseResponseDTO houseResponseDTO = calculadoraUtilsTest.utilTestHouseResponseDtos();

        String payloadJson = objectWriter.writeValueAsString(houseDTO);
        String expectedJson = objectWriter.writeValueAsString(houseResponseDTO);



        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .content(payloadJson).contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson,result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
