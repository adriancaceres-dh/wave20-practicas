package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.HouseUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    @Test
    @DisplayName("Calculo precio 1 habitacion - Camino Feliz :D")
    void shouldCalculatePriceProperlyOneRoom() {
        //arrange
        HouseResponseDTO expected = HouseUtilsGenerator.getHouseResponseManyRooms();
        //act
        HouseResponseDTO actual = service.calculate(HouseUtilsGenerator.getHouseManyRooms());
        //assert
        assertEquals(expected.getPrice(),actual.getPrice());
    }
    @Test
    @DisplayName("Calculo precio multiples habitaciones - Camino Feliz :D")
    void shouldCalculatePriceProperlyManyRooms() {
        //arrange
        HouseResponseDTO expected = HouseUtilsGenerator.getHouseResponseOneRoom();
        //act
        HouseResponseDTO actual = service.calculate(HouseUtilsGenerator.getHouseOneRoom());
        //assert
        assertEquals(expected.getPrice(),actual.getPrice());
    }
    @Test
    @DisplayName("Calculo habitacion mas grande una habitacion - Camino Feliz :D")
    void shouldCalculateBiggestRoomOutofOneProperly() {
        //arrange
        RoomDTO expectedRoom = new RoomDTO("Sala", 8, 5);
        //act
        HouseResponseDTO actual = service.calculate(HouseUtilsGenerator.getHouseOneRoom());
        //assert
        assertEquals(expectedRoom.getName(),actual.getBiggest().getName());
    }
    @Test
    @DisplayName("Calculo habitacion mas grande multiples habitaciones - Camino Feliz :D")
    void shouldCalculateBiggestRoomOutofManyProperly() {
        //arrange
        HouseResponseDTO expected = HouseUtilsGenerator.getHouseResponseManyRooms();
        //act
        HouseResponseDTO actual = service.calculate(HouseUtilsGenerator.getHouseManyRooms());
        //assert
        assertEquals(expected.getBiggest().getName(),actual.getBiggest().getName());
    }
    @Test
    @DisplayName("Calculo area construida multiples habitaciones - Camino Feliz :D")
    void shouldCalculateTotalSquareFeetProperlyManyRooms() {
        //arrange
        HouseResponseDTO expected = HouseUtilsGenerator.getHouseResponseManyRooms();
        //act
        HouseResponseDTO actual = service.calculate(HouseUtilsGenerator.getHouseManyRooms());
        //assert
        assertEquals(expected.getSquareFeet(),actual.getSquareFeet());
    }
}