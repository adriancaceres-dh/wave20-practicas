package com.mercadolibre.calculadorametroscuadrados.helper;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraHelper {

    public static HouseDTO createHouse() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress("Luis Alberto de Herrera 233");
        houseDTO.setName("Caudillos");

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setLength(100);
        room1.setWidth(100);
        room1.setName("Bano");
        RoomDTO room2 = new RoomDTO();
        room2.setLength(100);
        room2.setWidth(100);
        room2.setName("Cocina");
        RoomDTO room3 = new RoomDTO();
        room3.setLength(150);
        room3.setWidth(150);
        room3.setName("Sotano");
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        houseDTO.setRooms(rooms);

        return houseDTO;
    }

    public static HouseResponseDTO createHouseResponse() {
        HouseDTO houseDTO = createHouse();
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();

        houseResponseDTO.setName(houseDTO.getName());
        houseResponseDTO.setAddress(houseDTO.getAddress());
        houseResponseDTO.setRooms(houseDTO.getRooms());

        houseResponseDTO.setPrice(34000000);
        houseResponseDTO.setBiggest(houseDTO.getRooms().get(2));
        houseResponseDTO.setSquareFeet(42500);

        return houseResponseDTO;
    }
}
