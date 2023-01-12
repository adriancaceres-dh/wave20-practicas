package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.CalculadoraTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHouseResponseDTO() throws Exception {
        HouseDTO houseDTO = CalculadoraTestUtils.generateHouse();
        HouseResponseDTO expectedResponse = CalculadoraTestUtils.generateHouseResponse();

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(houseDTO);
        String payloadResponse = objectWriter.writeValueAsString(expectedResponse);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(payloadResponse, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
