package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculate() {
        //Arrange
        HouseDTO houseDTO=getHouseDTO();
        HouseResponseDTO expected=new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(50);
        expected.setPrice(40000);
        expected.setBiggest(houseDTO.getRooms().get(0));

        when(calculateService.calculate(houseDTO)).thenReturn(expected);
        //Act
        HouseResponseDTO response=calculateRestController.calculate(houseDTO);

        //Assert
        verify(calculateService,atLeast(1)).calculate(houseDTO);
        Assertions.assertEquals(expected,response);

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
}