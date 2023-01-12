package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private HouseDTO createHoseResponseDTO(){
        RoomDTO room1 = new RoomDTO();
        room1.setName("Terror");
        room1.setLength(3);
        room1.setWidth(3);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Romance");
        room2.setLength(4);
        room2.setWidth(5);

        RoomDTO room3 = new RoomDTO();
        room3.setName("Comedia");
        room3.setLength(2);
        room3.setWidth(3);

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        HouseDTO house = new HouseDTO();
        house.setName("peliculas");
        house.setAddress("Canelones 1252");
        house.setRooms(rooms);
        return house;

    }


    @Test
    public void calculateIntegrationTest()throws Exception{
        HouseDTO houseReturn = createHoseResponseDTO();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(houseReturn);
        MvcResult mvcResult= mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(35)) //aca compara lo del json con la respuesta esperada
                .andReturn();

    }


}
