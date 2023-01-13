package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Test
    void calculate() {
        //Arrange
        int priceExpected = 193600;
        //when(houseResponseDTO.getSquareFeet()).thenReturn(priceExpected);

        // Act
        RoomDTO roomDTO1 = new RoomDTO("room 1", 22, 11);
        List<RoomDTO> rooms = Arrays.asList(roomDTO1);
        //
        HouseDTO houseDTO1 = new HouseDTO("Chacras", "larrea 155", rooms);

        Integer precioActual = calculateService.calculate(houseDTO1).getPrice();

        assertEquals(priceExpected, precioActual);
    }

    @Test
    void calculateBiggestRoom(){
        //Arrange
        RoomDTO roomDTO1 = new RoomDTO("room 1", 22, 11);
        RoomDTO roomDTO2 = new RoomDTO("room 1", 25, 11);
        RoomDTO roomDTO3 = new RoomDTO("room 1", 30, 11);
        List<RoomDTO> rooms2 = Arrays.asList(roomDTO1, roomDTO2, roomDTO3);

        HouseDTO houseDTO2 = new HouseDTO("Laguna", "niña encantada", rooms2 );

        RoomDTO biggest = roomDTO3;

        RoomDTO expectedBiggest = biggest;

        // Act
        RoomDTO actualBiggest = calculateService.calculate(houseDTO2).getBiggest();
        assertEquals(expectedBiggest, actualBiggest);
    }
    @Test
    void calculateSqareMts(){
        //Arrange
        Integer expectesSqareMts1 = 726;
        Integer expectesSqareMts2 = 200;

        RoomDTO roomDTO11 = new RoomDTO("room 1", 22, 11);
        RoomDTO roomDTO22 = new RoomDTO("room 1", 44, 11);
        List<RoomDTO> rooms22 = Arrays.asList(roomDTO11, roomDTO22);
        HouseDTO houseDTO22 = new HouseDTO("eia", "encantada", rooms22 );
        // Act
        Integer actualSqareFeet = calculateService.calculate(houseDTO22).getSquareFeet();
        assertEquals(expectesSqareMts1, actualSqareFeet);
    }
}