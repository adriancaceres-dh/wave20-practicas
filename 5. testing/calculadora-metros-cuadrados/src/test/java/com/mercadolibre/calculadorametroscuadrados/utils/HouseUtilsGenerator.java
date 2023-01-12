package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;

public class HouseUtilsGenerator {

    public static RoomDTO getRoom (){
        return new RoomDTO("Sala", 8, 5);
    }
    public static RoomDTO getRoomNullWidth (){
        return new RoomDTO("Sala", null, 5);
    }
    public static RoomDTO getRoomNullDimensions (){
        return new RoomDTO("Sala", null, null);
    }


    public static HouseDTO getHouseOneRoom (){
        RoomDTO room1 = new RoomDTO("Sala", 8, 5);
        return new HouseDTO("Casa de Daniela", "Av. 123", Arrays.asList(room1));
    }
    public static HouseDTO getHouseManyRooms (){
        RoomDTO room1 = new RoomDTO("Sala", 8, 5);
        RoomDTO room2 = new RoomDTO("Cuarto", 6, 8);
        RoomDTO room3 = new RoomDTO("Baño", 5, 3);
        return new HouseDTO("Casa de Daniela", "Av. 123", Arrays.asList(room1, room2, room3));
    }

    public static HouseResponseDTO getHouseResponseOneRoom (){
        RoomDTO room1 = new RoomDTO("Sala", 8, 5);
        return new HouseResponseDTO("Casa de Daniela", "Av. 123", Arrays.asList(room1), 40, 32000, room1);
    }
    public static HouseResponseDTO getHouseResponseManyRooms (){
        RoomDTO room1 = new RoomDTO("Sala", 8, 5);
        RoomDTO room2 = new RoomDTO("Cuarto", 6, 8);
        RoomDTO room3 = new RoomDTO("Baño", 5, 3);
        return new HouseResponseDTO("Casa de Daniela", "Av. 123", Arrays.asList(room1, room2, room3), 103, 82400, room2);
    }

}
