package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

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
        //arrange
        HouseDTO houseDTO = TestUtils.createSimpleHouse("Direccion","Casa");
        HouseResponseDTO responseDTO = TestUtils.createHouseResponse("Direccion","Casa");
        when(calculateService.calculate(houseDTO)).thenReturn(responseDTO);

        HouseResponseDTO houseResponseDTO = calculateRestController.calculate(houseDTO);

        verify(calculateService,atLeastOnce()).calculate(houseDTO);

        //assert
        Assertions.assertEquals(responseDTO.toString(),houseResponseDTO.toString());

    }
}