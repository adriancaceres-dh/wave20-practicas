package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class calculadoraUtilsTest {

    public static HouseDTO utilTestHouseDtos(){
        HouseDTO houseDTO1 = new HouseDTO();
        houseDTO1.setName("Casa_1");
        houseDTO1.setAddress("cra 25 #6-50");
        houseDTO1.setRooms(new ArrayList<>());
        houseDTO1.getRooms().add(new RoomDTO("sala",10,8));
        houseDTO1.getRooms().add(new RoomDTO("cocina",11,8));
        houseDTO1.getRooms().add(new RoomDTO("cuarto",7,8));

        return houseDTO1;
    }

    public static HouseResponseDTO utilTestHouseResponseDtos(){
        HouseResponseDTO houseResponseDTO1 = new HouseResponseDTO();
        houseResponseDTO1.setName("Casa_1");
        houseResponseDTO1.setAddress("cra 25 #6-50");
        houseResponseDTO1.setPrice(179200);
        houseResponseDTO1.setSquareFeet(224);
        houseResponseDTO1.setRooms(new ArrayList<>());
        houseResponseDTO1.getRooms().add(new RoomDTO("sala",10,8));
        houseResponseDTO1.getRooms().add(new RoomDTO("cocina",11,8));
        houseResponseDTO1.getRooms().add(new RoomDTO("cuarto",7,8));
        houseResponseDTO1.getRooms().get(0).getSquareFeet();
        houseResponseDTO1.getRooms().get(1).getSquareFeet();
        houseResponseDTO1.getRooms().get(2).getSquareFeet();
        houseResponseDTO1.setBiggest(houseResponseDTO1.getRooms().get(1));

        return houseResponseDTO1;
    }
}
