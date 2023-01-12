package com.mercadolibre.calculadorametroscuadrados.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestCalculateRestController {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void calculateTestOk() throws Exception {
        RoomDTO room1=createRoom("room1",1,5);
        RoomDTO room2=createRoom("room2",2,4);
        RoomDTO room3=createRoom("room3",2,3);
        List<RoomDTO> rooms = new ArrayList<>(){{
            add(room1);
            add(room2);
            add(room3);
        }};
        HouseDTO houseDTO = createHouse("House1","Address1",rooms);

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(19))
                .andExpect(jsonPath("$.price").value(15200))
                .andExpect(jsonPath("$.biggest.name").value("room2"));
    }

    @Test
    public void calculateTestEmptyRooms() throws Exception {
        List<RoomDTO> rooms = new ArrayList<>();
        HouseDTO houseDTO = createHouse("House1","Address1",rooms);

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(0))
                .andExpect(jsonPath("$.price").value(0))
                .andExpect(jsonPath("$.biggest").isEmpty());
    }

}
