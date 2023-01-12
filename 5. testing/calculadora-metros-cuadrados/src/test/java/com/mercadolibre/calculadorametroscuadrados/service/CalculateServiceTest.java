package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {
  private final CalculateService calculateService = new CalculateService();
  @Test
  void testCalculate() {
    //arrange
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

    //act
    HouseResponseDTO response = calculateService.calculate(houseDTO);

    //assert
    assertEquals(32, response.getSquareFeet());
    assertEquals(room1, response.getBiggest());
    assertEquals(25600, response.getPrice());
  }
}
