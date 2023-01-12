package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.HouseTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTests {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateOk() {
        // arrange
        RoomDTO bigRoom = HouseTestUtils.getBigRoom();
        RoomDTO smallRoom = HouseTestUtils.getSmallRoom();
        HouseDTO house = HouseTestUtils.getMockHouseDTO(List.of(bigRoom, smallRoom));

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setBiggest(bigRoom);
        expected.setSquareFeet(88);
        expected.setPrice(70400);

        when(calculateService.calculate(house)).thenReturn(expected);

        // act
        HouseResponseDTO actual = calculateRestController.calculate(house);

        // assert
        verify(calculateService, atLeastOnce()).calculate(house);
        assertEquals(expected, actual);
    }
}
