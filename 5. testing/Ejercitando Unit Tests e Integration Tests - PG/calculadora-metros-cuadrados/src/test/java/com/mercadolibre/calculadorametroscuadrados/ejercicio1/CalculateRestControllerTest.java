package com.mercadolibre.calculadorametroscuadrados.ejercicio1;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.UtilTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.bind.annotation.XmlElementDecl;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateOk(){
        //Arrange
        HouseDTO houseDTO = UtilTest.getHouse();
        HouseResponseDTO expectedhouseResponseDTO = UtilTest.getHouseResponseDTO(houseDTO);

        //Act
        HouseResponseDTO actualHouseResponseDTO = calculateRestController.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expectedhouseResponseDTO, actualHouseResponseDTO);
    }
}
