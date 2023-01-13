package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String houseDTOName = "chalet 3 ambientes";
    private final String houseDTOAddress = "Molina Arrotea 456";
    private final int houseDTOPrice = 28800;
    private final String biggestRoomName = "cuarto con camas marineras";
    private final String regularRoomName = "cuarto con baño";
    private final String smallestRoomName = "cuarto con cama doble";

    private final int biggestRoomSquareFeet = 15;
    private final int regularRoomSquareFeet = 12;
    private final int smallestRoomSquareFeet = 9;


    @Test
    public void obtainTheRightPrice() throws JsonProcessingException {
        String request = createHouseRequestJson();
        try {
            this.mockMvc.perform(post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.price").value(houseDTOPrice));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void obtainTheRightValuesForEachRoomSquareFeet() throws JsonProcessingException {
        String request = createHouseRequestJson();
        try {
            this.mockMvc.perform(post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.rooms[0].squareFeet").value(smallestRoomSquareFeet))
                    .andExpect(jsonPath("$.rooms[1].squareFeet").value(regularRoomSquareFeet))
                    .andExpect(jsonPath("$.rooms[2].squareFeet").value(biggestRoomSquareFeet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void obtainTheBiggestRoom() throws JsonProcessingException {
        String request = createHouseRequestJson();
        try {
            this.mockMvc.perform(post("/calculate")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(request))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.biggest.squareFeet").value(biggestRoomSquareFeet))
                    .andExpect(jsonPath("$.biggest.name").value(biggestRoomName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String createHouseRequestJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO(smallestRoomName, 3, 3));
        rooms.add(new RoomDTO(regularRoomName, 3, 4));
        rooms.add(new RoomDTO(biggestRoomName, 3, 5));

        return mapper.writeValueAsString(new HouseDTO(houseDTOName, houseDTOAddress, rooms));
    }
}