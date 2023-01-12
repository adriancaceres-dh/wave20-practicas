package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {
  @Mock
  private CalculateService calculateServiceMock;

  @InjectMocks
  private CalculateRestController calculateController;

  private HouseResponseDTO houseResponseDTO;
  private HouseDTO houseDTO;

  private List<RoomDTO> rooms;


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
    rooms = List.of(room1, room2);
    houseDTO = HouseDTO.builder()
            .name("Casa")
            .address("Av. Siempreviva 742")
            .rooms(rooms)
            .build();
    houseResponseDTO = new HouseResponseDTO(houseDTO);
    houseResponseDTO.setSquareFeet(32);
    houseResponseDTO.setBiggest(room1);
    houseResponseDTO.setPrice(25600);
    when(calculateServiceMock.calculate(any())).thenReturn(houseResponseDTO);

    //act
    HouseResponseDTO result = calculateController.calculate(houseDTO);

    //assert
    assertEquals(32, result.getSquareFeet());
    assertEquals(room1, result.getBiggest());
    assertEquals(25600, result.getPrice());
  }

}
