package com.mercadolibre.romannumerals;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;


public class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();
    @Test
    void toRomanOK(){
        //arrange
        String expected = "V";
        //Act
        String actual =  romanNumeralsRestController.toRoman(5);
        //Assert
        Assertions.assertEquals(expected,actual);
    }
    //test con parametros
    @ParameterizedTest
    @MethodSource("provideParameters")
    void toRomanOK(int num, String letra){
        //arrange
        String expected = letra;
        //Act
        String actual =  romanNumeralsRestController.toRoman(num);
        //Assert
        Assertions.assertEquals(expected,actual);
    }
    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(5, "V"),
                Arguments.of(7, "VII"),
                Arguments.of(10, "X"),
                Arguments.of(50, "L")
        );
    }

}
