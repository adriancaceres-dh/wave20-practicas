package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.HouseTestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTests {

    CalculateService calculateService;

    public CalculateServiceTests() {
        calculateService = new CalculateService();
    }

    @Test
    void calculateOk() {
        // arrange
        Integer expectedSquareFeet = 88;
        Integer expectedPrice = 70400;

        RoomDTO bigRoom = HouseTestUtils.getBigRoom();
        RoomDTO smallRoom = HouseTestUtils.getSmallRoom();
        HouseDTO house = HouseTestUtils.getMockHouseDTO(List.of(bigRoom, smallRoom));

        // act
        HouseResponseDTO actual = calculateService.calculate(house);

        // assert
        assertEquals(expectedPrice, actual.getPrice());
        assertEquals(bigRoom, actual.getBiggest());
        assertEquals(expectedSquareFeet, actual.getSquareFeet());
    }
}
