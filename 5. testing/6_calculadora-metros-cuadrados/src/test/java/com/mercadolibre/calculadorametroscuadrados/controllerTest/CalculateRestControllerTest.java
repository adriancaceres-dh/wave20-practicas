package com.mercadolibre.calculadorametroscuadrados.controllerTest;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

/*    @Test
    public void calculateTestOk(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        CalculateService calculateService1 = mock(CalculateService.class);
        when(calculateService.calculate(houseDTO)).thenReturn(new HouseResponseDTO());
        //Act
        HouseResponseDTO houseResponseDTO= calculateRestController.calculate(houseDTO);
        //Assert
        verify(calculateService,times(1)).calculate(houseDTO);
    }*/

}
