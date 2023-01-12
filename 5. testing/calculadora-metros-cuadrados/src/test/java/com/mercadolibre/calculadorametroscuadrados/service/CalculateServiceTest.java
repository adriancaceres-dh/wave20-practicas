package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    private final CalculateService calculateService;

    public CalculateServiceTest () {
        calculateService = new CalculateService();
    }

    private HouseDTO buildHouse() {
        RoomDTO smallRoom = new RoomDTO();
        smallRoom.setLength(5);
        smallRoom.setWidth(5);
        RoomDTO bigRoom = new RoomDTO();
        bigRoom.setLength(10);
        bigRoom.setWidth(10);
        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(smallRoom, bigRoom));

        return house;
    }

    private HouseResponseDTO buildResponseHouse (HouseDTO house) {
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setBiggest(house.getRooms().get(1));
        expectedResponse.setSquareFeet(125);
        expectedResponse.setPrice(100000);

        return expectedResponse;
    }

    @Test
    @DisplayName("Calculate house price")
    public void calculateHousePriceTest () {
        // Arrange
        HouseDTO house = buildHouse();
        HouseResponseDTO expectedResponse = buildResponseHouse(house);
        // Act
        HouseResponseDTO actualResponse = calculateService.calculate(house);
        // Assert
        assertEquals(expectedResponse.getPrice(), actualResponse.getPrice());
    }

    @Test
    @DisplayName("Calculate sq feet in house")
    public void calculateHouseAreaTest () {
        // Arrange
        HouseDTO house = buildHouse();
        HouseResponseDTO expectedResponse = buildResponseHouse(house);
        // Act
        HouseResponseDTO actualResponse = calculateService.calculate(house);
        // Assert
        assertEquals(expectedResponse.getRooms(), actualResponse.getRooms());
        assertEquals(expectedResponse.getSquareFeet(), actualResponse.getSquareFeet());
    }

    @Test
    @DisplayName("Set room with most sq feet as biggest")
    public void calculateBiggestRoomTest () {
        // Arrange
        HouseDTO house = buildHouse();
        HouseResponseDTO expectedResponse = buildResponseHouse(house);
        // Act
        HouseResponseDTO actualResponse = calculateService.calculate(house);
        // Assert
        assertEquals(expectedResponse.getBiggest(), actualResponse.getBiggest());
    }

    @Test
    @DisplayName("Calculate house price with no rooms")
    public void calculateEmptyHouseTest () {
        // Arrange
        HouseDTO house = new HouseDTO();
        house.setName("Empty House");
        house.setAddress("Nowhere");
        house.setRooms(new ArrayList<>());

        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setSquareFeet(0);
        expectedResponse.setPrice(0);
        // Act
        HouseResponseDTO actualResponse = calculateService.calculate(house);
        // Assert
        assertEquals(expectedResponse.getName(), actualResponse.getName());
        assertEquals(expectedResponse.getAddress(), actualResponse.getAddress());
        assertEquals(expectedResponse.getRooms(), actualResponse.getRooms());
        assertEquals(expectedResponse.getSquareFeet(), actualResponse.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), actualResponse.getPrice());
        assertEquals(expectedResponse.getBiggest(), actualResponse.getBiggest());
    }
}
