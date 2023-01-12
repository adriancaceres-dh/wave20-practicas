package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static HouseDTO createSimpleHouse(String address,String name){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress(address);
        houseDTO.setName(name);
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO sala = new RoomDTO();
        sala.setName("Pieza");
        sala.setLength(20);
        sala.setWidth(20);

        roomDTOList.add(sala);
        houseDTO.setRooms(roomDTOList);
        return houseDTO;
    }

    public static HouseResponseDTO createHouseResponse(String address,String name){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setPrice(320000);
        RoomDTO sala = new RoomDTO();
        sala.setName("Pieza");
        sala.setLength(20);
        sala.setWidth(20);
        houseResponseDTO.setSquareFeet(400);
        houseResponseDTO.setBiggest(sala);
        houseResponseDTO.setName(name);
        houseResponseDTO.setAddress(address);

        return houseResponseDTO;
    }
}
