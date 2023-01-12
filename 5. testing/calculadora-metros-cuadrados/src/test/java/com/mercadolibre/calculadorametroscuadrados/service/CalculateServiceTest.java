package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.CalculadoraTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculate() {
        HouseDTO house = CalculadoraTestUtils.generateHouse();
        Integer expectedSquareFeet = CalculadoraTestUtils.GENERATED_HOUSE_SQUARE_FEET;
        Integer expectedPrice = CalculadoraTestUtils.GENERATED_HOUSE_SQUARE_FEET * 800;
        RoomDTO biggestRoom = house.getRooms().get(2);

        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        assertEquals(expectedSquareFeet, houseResponseDTO.getSquareFeet());
        assertEquals(expectedPrice, houseResponseDTO.getPrice());
        assertEquals(biggestRoom, houseResponseDTO.getBiggest());
    }
}