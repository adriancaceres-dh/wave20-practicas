package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mercadolibre.calculadorametroscuadrados.calculadoraUtilsTest;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    @InjectMocks
    CalculateService calculateService;


    @Test
    public void calculateOk(){
        //Arrange
        HouseDTO houseDTO = calculadoraUtilsTest.utilTestHouseDtos();
        HouseResponseDTO expectedHouseResponseDTO = calculadoraUtilsTest.utilTestHouseResponseDtos();

        //Act
        HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedHouseResponseDTO,actualHouseResponseDTO);


    }
}
