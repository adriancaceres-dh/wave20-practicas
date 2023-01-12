package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestUtils {


    public static HouseResponseDTO createHouseResponse(HouseDTO house, Integer squareFeet, Integer price, RoomDTO biggest){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setSquareFeet(squareFeet);
        houseResponseDTO.setPrice(price);
        houseResponseDTO.setBiggest(biggest);
        return houseResponseDTO;
    }
    public static RoomDTO createRoom(String name, Integer width, Integer length){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(name);
        roomDTO.setWidth(width);
        roomDTO.setLength(length);
        return roomDTO;
    }
    public static HouseDTO createHouse(String name, String address, List<RoomDTO> rooms){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName(name);
        houseDTO.setAddress(address);
        houseDTO.setRooms(rooms);
        return houseDTO;
    }

}
