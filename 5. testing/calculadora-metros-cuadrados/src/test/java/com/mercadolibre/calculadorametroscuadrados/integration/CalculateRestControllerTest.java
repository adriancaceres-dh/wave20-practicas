package com.mercadolibre.calculadorametroscuadrados.integration;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.HouseUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldCalculateHouseWithManyRooms() throws Exception {
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 5, 5) + "," +
                getRoom("Cocina", 3, 3) + "," +
                getRoom("Baño", 2, 1) +
                "]}";
        this.mockMvc.perform(
                    post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(request))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }


    private String getRoom(String name, int width, int length) {
        return "{\"name\": \"" + name + "\", \"width\": " + width + ", \"length\": " + length + "}";
    }
}