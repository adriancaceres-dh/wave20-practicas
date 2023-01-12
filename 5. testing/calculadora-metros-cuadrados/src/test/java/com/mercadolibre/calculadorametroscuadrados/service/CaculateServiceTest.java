package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CaculateServiceTest {


    private CalculateService calculateService;

    public CaculateServiceTest(){
        this.calculateService = new CalculateService();
    }

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
    public void calculatePricePropertyTest(){
        HouseDTO houseReturn = createHoseResponseDTO();

        HouseResponseDTO response = calculateService.calculate(houseReturn);

        Assertions.assertEquals(28000,response.getPrice());

    }

    @Test
    public void calculateBigHoseTest(){
        HouseDTO houseReturn = createHoseResponseDTO();

        HouseResponseDTO response = calculateService.calculate(houseReturn);

        Assertions.assertEquals(houseReturn.getRooms().get(1).getName(),response.getBiggest().getName());
        Assertions.assertEquals(houseReturn.getRooms().get(1).getLength(),response.getBiggest().getLength());
        Assertions.assertEquals(houseReturn.getRooms().get(1).getWidth(),response.getBiggest().getWidth());

    }

    @Test
    public void calculateSquareFeetTest(){
        HouseDTO houseReturn = createHoseResponseDTO();

        HouseResponseDTO response = calculateService.calculate(houseReturn);

        Assertions.assertEquals(35,response.getSquareFeet());

    }






}
