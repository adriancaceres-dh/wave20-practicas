package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import org.junit.jupiter.api.Test;

import static com.mercadolibre.calculadorametroscuadrados.helper.CalculadoraHelper.createHouse;
import static com.mercadolibre.calculadorametroscuadrados.helper.CalculadoraHelper.createHouseResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();


    @Test
    void calculate() {
        HouseDTO houseDTO = createHouse();
        HouseResponseDTO expectedResponse = createHouseResponse();

        HouseResponseDTO actualResponse = calculateService.calculate(houseDTO);

        assertEquals(expectedResponse, actualResponse);
    }
}
