package com.mercadolibre.calculadorametroscuadrados.unitTest;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();

    @Test
    void testCalculate(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Hogar");
        houseDTO.setAddress("Cll 98");
        RoomDTO room1 = new RoomDTO();
        room1.setName("Habitacion1");
        room1.setWidth(2);
        room1.setLength(2);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion2");
        room2.setWidth(1);
        room2.setLength(1);
        houseDTO.setRooms(List.of(room1,room2));
        HouseResponseDTO expectedResponse = new HouseResponseDTO();
        expectedResponse.setSquareFeet(5);
        expectedResponse.setPrice(4000);
        expectedResponse.setBiggest(room1);
        //Act
        HouseResponseDTO actualResponse = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);
    }

    @Test
    void testCalculateRoomSquareFeet(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Hogar");
        houseDTO.setAddress("Cll 98");
        RoomDTO room1 = new RoomDTO();
        room1.setName("Habitacion1");
        room1.setWidth(2);
        room1.setLength(2);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion2");
        room2.setWidth(1);
        room2.setLength(1);
        houseDTO.setRooms(List.of(room1,room2));
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);

        //Act
        calculateService.calculateRoomSquareFeet(houseDTO,houseResponseDTO);
        System.out.println(houseResponseDTO.toString());

        //Assert
        Assertions.assertEquals(houseResponseDTO.getSquareFeet(), 5);

    }

    @Test
    void testCalculatePrice(){
        //Arrange
        Integer result =5;
        int expectedResponse = 4000;
        //Act
        int actualResponse = calculateService.calculatePrice(5);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }


}
