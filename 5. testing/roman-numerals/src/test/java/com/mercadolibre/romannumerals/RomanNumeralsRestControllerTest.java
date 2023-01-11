package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    private static RomanNumeralsRestController romanNumeralsRestController;

    @BeforeAll
    public static void initAll() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    public void givenOneWhenConvertedThenShouldReturnI() {
        String romanNumber = romanNumeralsRestController.toRoman(1);
        assertEquals("I", romanNumber);
    }

    @Test
    public void givenThreeWhenConvertedThenShouldReturnIII() {
        String romanNumber = romanNumeralsRestController.toRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void givenFiveWhenConvertedThenShouldReturnV() {
        String romanNumber = romanNumeralsRestController.toRoman(5);
        assertEquals("V", romanNumber);
    }

    @Test
    public void givenSevenWhenConvertedThenShouldReturnVII() {
        String romanNumber = romanNumeralsRestController.toRoman(7);
        assertEquals("VII", romanNumber);
    }

    @Test
    public void givenTenWhenConvertedThenShouldReturnX() {
        String romanNumber = romanNumeralsRestController.toRoman(10);
        assertEquals("X", romanNumber);
    }

    @Test
    public void givenFiftyWhenConvertedThenShouldReturnL() {
        String romanNumber = romanNumeralsRestController.toRoman(50);
        assertEquals("L", romanNumber);
    }


}