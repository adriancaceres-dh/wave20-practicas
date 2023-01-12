package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestUtils {
    public static HouseDTO buildHouse() {
        RoomDTO smallRoom = new RoomDTO();
        smallRoom.setLength(5);
        smallRoom.setWidth(5);
        RoomDTO bigRoom = new RoomDTO();
        bigRoom.setLength(10);
        bigRoom.setWidth(10);
        HouseDTO house = new HouseDTO();
        house.setRooms(List.of(smallRoom, bigRoom));

        return house;
    }

    public static HouseResponseDTO buildResponseHouse (HouseDTO house) {
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setBiggest(house.getRooms().get(1));
        expectedResponse.setSquareFeet(125);
        expectedResponse.setPrice(100000);

        return expectedResponse;
    }
}
