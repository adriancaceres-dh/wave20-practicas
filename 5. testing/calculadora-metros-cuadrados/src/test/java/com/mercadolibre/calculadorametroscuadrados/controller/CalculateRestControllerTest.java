package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.mercadolibre.calculadorametroscuadrados.calculadoraUtilsTest;


@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    public void calculateOk(){
        //Arrange
        HouseDTO houseDTO = calculadoraUtilsTest.utilTestHouseDtos();
        HouseResponseDTO expectedHouseResponseDTO = calculadoraUtilsTest.utilTestHouseResponseDtos();

        //Act
        HouseResponseDTO actualHouseResponseDTO = calculateRestController.calculate(houseDTO);
        //Assert
        Assertions.assertEquals(expectedHouseResponseDTO,actualHouseResponseDTO);


    }



}
