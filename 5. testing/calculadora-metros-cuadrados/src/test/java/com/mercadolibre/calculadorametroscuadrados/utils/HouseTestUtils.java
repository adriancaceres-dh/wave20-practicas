package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class HouseTestUtils {

    public static HouseDTO getMockHouseDTO(List<RoomDTO> rooms) {
        HouseDTO house = new HouseDTO();
        house.setName("Main House");
        house.setAddress("Montes, Jalisco, MX");
        house.setRooms(rooms);

        return house;
    }

    public static RoomDTO getBigRoom() {
        RoomDTO room = new RoomDTO();
        room.setName("Big");
        room.setLength(8);
        room.setWidth(7);

        return room;
    }

    public static RoomDTO getSmallRoom() {
        RoomDTO room = new RoomDTO();
        room.setName("Small");
        room.setLength(4);
        room.setWidth(8);

        return room;
    }
}
