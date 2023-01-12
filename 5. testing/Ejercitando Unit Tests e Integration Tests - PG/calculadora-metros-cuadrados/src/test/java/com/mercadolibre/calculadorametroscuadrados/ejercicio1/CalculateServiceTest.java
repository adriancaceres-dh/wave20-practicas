package com.mercadolibre.calculadorametroscuadrados.ejercicio1;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.UtilTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Test
    void calculateOk(){
        //Arrange
        HouseDTO houseDTO = UtilTest.getHouse();
        HouseResponseDTO expectedhouseResponseDTO = UtilTest.getHouseResponseDTO(houseDTO);

        //Act
       HouseResponseDTO actualHouseResponseDTO = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedhouseResponseDTO, actualHouseResponseDTO);
        Assertions.assertEquals(89, actualHouseResponseDTO.getSquareFeet());
        Assertions.assertEquals(7, actualHouseResponseDTO.getBiggest().getWidth());
        Assertions.assertEquals(7, actualHouseResponseDTO.getBiggest().getLength());
        Assertions.assertEquals(40, actualHouseResponseDTO.getRooms().get(0).getSquareFeet());
    }

}
