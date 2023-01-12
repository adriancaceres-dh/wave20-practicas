package com.mercadolibre.calculadorametroscuadrados.dto;

import com.mercadolibre.calculadorametroscuadrados.utils.HouseUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomDTOTest {

    @Test
    @DisplayName("Calculo area construida - Camino feliz :D")
    void shouldCalculateSquareFeet() {
        //arrange
        RoomDTO room = HouseUtilsGenerator.getRoom();
        //act
        int actual = room.getSquareFeet();
        //assert
        assertEquals(40, actual);
    }
    @Test
    @DisplayName("Calculo area construida - Ancho nulo :/")
    void shouldCalculateSquareFeetWhenOneDimensionIsNull() {
        //arrange
        RoomDTO room = HouseUtilsGenerator.getRoomNullWidth();
        //act
        int actual = room.getSquareFeet();
        //assert
        assertEquals(0, actual);
    }
    @Test
    @DisplayName("Calculo area construida - Dimensiones nulas >:(")
    void shouldCalculateSquareFeetWhenDimensionsAreNull() {
        //arrange
        RoomDTO room = HouseUtilsGenerator.getRoomNullDimensions();
        //act
        int actual = room.getSquareFeet();
        //assert
        assertEquals(0, actual);
    }
}