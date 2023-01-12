package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class CalculadoraTestUtils {
    public static Integer GENERATED_HOUSE_SQUARE_FEET = 4 * 2 + 8 * 3 + 5 * 6;

    public static HouseDTO generateHouse() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Estilo mediterráneo");
        houseDTO.setAddress("Siempreviva 742");
        RoomDTO banio = new RoomDTO();
        banio.setLength(4);
        banio.setWidth(2);
        banio.setName("Baño");
        RoomDTO cocina = new RoomDTO();
        cocina.setLength(8);
        cocina.setWidth(3);
        cocina.setName("Cocina");
        RoomDTO cuarto = new RoomDTO();
        cuarto.setWidth(5);
        cuarto.setLength(6);
        cuarto.setName("Dormitorio");
        houseDTO.setRooms(List.of(banio, cocina, cuarto));
        return houseDTO;
    }

    public static HouseResponseDTO generateHouseResponse() {
        HouseDTO houseDTO = generateHouse();
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setName(houseDTO.getName());
        houseResponseDTO.setBiggest(houseDTO.getRooms().get(2));
        houseResponseDTO.setPrice(GENERATED_HOUSE_SQUARE_FEET * 800);
        houseResponseDTO.setSquareFeet(GENERATED_HOUSE_SQUARE_FEET);
        houseResponseDTO.setAddress(houseDTO.getAddress());
        houseResponseDTO.setRooms(houseDTO.getRooms());
        return houseResponseDTO;
    }
}
