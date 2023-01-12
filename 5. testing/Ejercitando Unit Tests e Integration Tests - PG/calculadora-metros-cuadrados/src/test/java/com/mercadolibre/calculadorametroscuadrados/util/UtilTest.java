package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static HouseDTO getHouse(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House 1");
        houseDTO.setAddress("Direcc");
        List<RoomDTO> rooms = new ArrayList<>();

        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Room1");
        roomDTO1.setWidth(8);
        roomDTO1.setLength(5);
        roomDTO1.getSquareFeet();

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Room2");
        roomDTO2.setWidth(7);
        roomDTO2.setLength(7);
        roomDTO2.getSquareFeet();

        rooms.add(roomDTO1);
        rooms.add(roomDTO2);

        houseDTO.setRooms(rooms);

        return houseDTO;
    }

    public static HouseResponseDTO getHouseResponseDTO(HouseDTO houseDTO){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setName(houseDTO.getName());
        houseResponseDTO.setSquareFeet(89);
        houseResponseDTO.setPrice(71200);
        houseResponseDTO.setBiggest(houseDTO.getRooms().get(1));

        return houseResponseDTO;
    }
}
