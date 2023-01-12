package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    CalculateService calculateService= new CalculateService();
    @Test
    void calculate() {
        //Arrange
        HouseDTO houseDTO=getHouseDTO();
        RoomDTO biggestRoom=getBiggestRoom();
        HouseResponseDTO expected=new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(50);
        expected.setPrice(40000);
        expected.setBiggest(biggestRoom);
        int expectedSquareFeetRoom1=30;
        int expectedSquareFeetRoom2=20;

        //Act
        HouseResponseDTO response=calculateService.calculate(houseDTO);
        //Assert
        Assertions.assertEquals(expected.getSquareFeet(),response.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest().toString(),response.getBiggest().toString());
        Assertions.assertEquals(expectedSquareFeetRoom1
                ,response.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(expectedSquareFeetRoom2
                ,response.getRooms().get(1).getSquareFeet());
        Assertions.assertEquals(expected.getPrice()
                ,response.getPrice());
    }

    private HouseDTO getHouseDTO(){
        List<RoomDTO> roomDTOS=new ArrayList<>();
        RoomDTO room1=new RoomDTO();
        room1.setName("habitación principal");
        room1.setLength(5);
        room1.setWidth(6);
        RoomDTO room2=new RoomDTO();
        room2.setName("habitación visitas");
        room2.setLength(4);
        room2.setWidth(5);

        roomDTOS.add(room1);
        roomDTOS.add(room2);

        HouseDTO houseDTO=new HouseDTO();
        houseDTO.setName("casa ciudad");
        houseDTO.setAddress("calle 56 n 28-05");
        houseDTO.setRooms(roomDTOS);

        return  houseDTO;
    }
    private RoomDTO getBiggestRoom(){

        RoomDTO room1=new RoomDTO();
        room1.setName("habitación principal");
        room1.setLength(5);
        room1.setWidth(6);
        return  room1;
    }
}