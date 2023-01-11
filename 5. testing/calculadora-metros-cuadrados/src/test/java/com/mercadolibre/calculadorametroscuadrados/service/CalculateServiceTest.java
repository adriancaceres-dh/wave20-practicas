package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    private static CalculateService calculateService;

    @BeforeAll
    public static void setAll() {
        calculateService = new CalculateService();
    }

    @Test
    public void calculate() {
        HouseDTO house = getHouseDto();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(55, response.getSquareFeet());
        assertEquals(44000, response.getPrice());
        assertEquals("Room 1", response.getBiggest().getName());
        assertEquals(50, response.getRooms().get(0).getSquareFeet());
        assertEquals(5, response.getRooms().get(1).getSquareFeet());
    }

    private HouseDTO getHouseDto() {
        HouseDTO house = new HouseDTO();
        house.setName("Home");
        house.setAddress("9 de Julio 931");
        RoomDTO room1 = new RoomDTO();
        room1.setName("Room 1");
        room1.setWidth(10);
        room1.setLength(5);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Room 2");
        room2.setWidth(1);
        room2.setLength(5);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        house.setRooms(rooms);
        return house;
    }

}