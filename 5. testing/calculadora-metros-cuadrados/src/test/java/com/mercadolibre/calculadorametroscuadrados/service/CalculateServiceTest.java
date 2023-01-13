package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    private final String houseDtoName = "Departamento 2 ambientes";
    private final String houseDtoAddress = "9 de Julio 931";
    private final int houseDtoPrice = 44000;
    private final int houseDtoSquareFeet=55;
    private final String biggestRoomName = "cuarto de invitados";
    private final int biggestRoomSquareFeet=50;
    private final String smallestRoomName = "cuarto de trofeos";
    private final int smallestRoomSquareFeet=5;

    private static CalculateService calculateService;

    @BeforeAll
    public static void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    public void obtainTheCorrectValuesForAHouse() {
        HouseDTO house = createHouseDto();

        HouseResponseDTO response = calculateService.calculate(house);

        assertEquals(houseDtoSquareFeet, response.getSquareFeet());
        assertEquals(houseDtoPrice, response.getPrice());
        assertEquals(biggestRoomName, response.getBiggest().getName());
        assertEquals(biggestRoomSquareFeet, response.getRooms().get(0).getSquareFeet());
        assertEquals(smallestRoomSquareFeet, response.getRooms().get(1).getSquareFeet());
    }


    private HouseDTO createHouseDto() {

        HouseDTO house = new HouseDTO();
        house.setName(houseDtoName);
        house.setAddress(houseDtoAddress);

        RoomDTO room1 = new RoomDTO();
        room1.setName(biggestRoomName);
        room1.setWidth(10);
        room1.setLength(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName(smallestRoomName);
        room2.setWidth(1);
        room2.setLength(5);

        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        house.setRooms(rooms);
        return house;
    }
}