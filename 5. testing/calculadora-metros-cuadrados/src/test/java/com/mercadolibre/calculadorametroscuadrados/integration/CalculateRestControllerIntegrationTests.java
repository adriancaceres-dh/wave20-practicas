package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.HouseTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    public CalculateRestControllerIntegrationTests() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void calculate() throws Exception {
        // arrange
        RoomDTO bigRoom = HouseTestUtils.getBigRoom();
        RoomDTO smallRoom = HouseTestUtils.getSmallRoom();
        HouseDTO payloadDTO = HouseTestUtils.getMockHouseDTO(List.of(bigRoom, smallRoom));

        HouseResponseDTO expected = new HouseResponseDTO(payloadDTO);
        expected.setBiggest(bigRoom);
        expected.setSquareFeet(88);
        expected.setPrice(70400);

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String expectedJson = writer.writeValueAsString(expected);

        // act & assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // assert
        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void calculateEmptyBody() throws Exception {
        // arrange
        // act & assert
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }
}
