package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  private static ObjectWriter writer;

  @BeforeAll
  public static void setUp() {
    writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
  }

  @Test
  void testCalculate() throws Exception {
    //arange
    RoomDTO room1 = RoomDTO.builder()
            .name("Sala")
            .width(5)
            .length(4)
            .build();
    RoomDTO room2 = RoomDTO.builder()
            .name("Cocina")
            .width(4)
            .length(3)
            .build();
    HouseDTO houseDTO = HouseDTO.builder()
            .name("Casa")
            .address("Av. Siempreviva 742")
            .rooms(List.of(room1, room2))
            .build();
    String jsonHouse = writer.writeValueAsString(houseDTO);

    //act & assert
    this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonHouse))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(32))
            .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.name").value("Sala"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25600))
            .andReturn();
  }

}
