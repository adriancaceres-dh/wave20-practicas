package com.mercadolibre.calculadorametroscuadrados.serviceTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtils.*;

public class CalculateServiceTest {

    private CalculateService calculateService= new CalculateService();

    @Test
    public void calculateTestOk(){
        //Arrange
        RoomDTO room1= createRoom("room1",1,5);
        RoomDTO room2=createRoom("room2",2,4);
        RoomDTO room3=createRoom("room3",2,3);
        List<RoomDTO> rooms = new ArrayList<>(){{
            add(room1);
            add(room2);
            add(room3);
        }};
        HouseDTO houseDTO = createHouse("House1","Address1",rooms);
        HouseResponseDTO expected= createHouseResponse(houseDTO,19, 15200, room2);
        //Act
        HouseResponseDTO result= calculateService.calculate(houseDTO);
        //Assert
        Assertions.assertEquals(expected.getSquareFeet(),result.getSquareFeet());
        Assertions.assertEquals(expected.getPrice(),result.getPrice());
        Assertions.assertEquals(expected.getBiggest().getName(),result.getBiggest().getName());
    }
    @Test
    public void calculateTestEmptyRooms(){
        //Arrange
        List<RoomDTO> rooms = new ArrayList<>();
        HouseDTO houseDTO = createHouse("House1","Address1",rooms);
        //Act
        HouseResponseDTO result= calculateService.calculate(houseDTO);
        //Assert
        Assertions.assertEquals(0,result.getSquareFeet());
        Assertions.assertEquals(0,result.getPrice());
        Assertions.assertEquals(null,result.getBiggest());
    }

/*    @Test
    public void calculateTestNullRooms(){
        //Arrange
        HouseDTO houseDTO = createHouse("House1","Address1",null);
        //Act
        HouseResponseDTO result= calculateService.calculate(houseDTO);
        //Assert
        Assertions.assertEquals(0,result.getSquareFeet());
        Assertions.assertEquals(0,result.getPrice());
        Assertions.assertEquals(null,result.getBiggest());
    }*/

}
