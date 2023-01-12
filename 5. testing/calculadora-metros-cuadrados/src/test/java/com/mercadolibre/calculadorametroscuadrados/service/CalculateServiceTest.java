package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {


    private CalculateService calculateService;


    @BeforeEach
    void create(){
        calculateService = new CalculateService();
    }

    @Test
    void calculate() {
        HouseDTO houseDTO = TestUtils.createSimpleHouse("Casa","Direccion");
        HouseResponseDTO expectedResponse = TestUtils
                        .createHouseResponse("Casa","Direccion");
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
        Assertions.assertEquals(expectedResponse.toString(),houseResponseDTO.toString());
    }
}