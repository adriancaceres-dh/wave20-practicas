package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsRestControllerTests {

    RomanNumeralsRestController romanNumeralsRestController;

    public RomanNumeralsRestControllerTests() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    void toRomanOk() {
        // arrange
        Integer[] numbers = new Integer[]{1, 3, 5, 7, 10, 50};
        String[] expected = new String[]{"I", "III", "V", "VII", "X", "L"};
        // act & assert
        for(int i=0; i<numbers.length; i++) {
            assertRomanExpected(numbers[i], expected[i]);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,I", "3,III", "5,V", "7,VII", "10,X", "50,L"})
    void toRomanOkParameterized(String source) {
        // arrange
        String[] split = source.split(",");
        Integer number = Integer.parseInt(split[0]);
        // act & assert
        assertRomanExpected(number, split[1]);
    }

    @Test
    void toRomanLarge() {
        // arrange
        Integer number = 4999;
        String expected = "MMMMCMXCIX";
        // act & assert
        assertRomanExpected(number, expected);
    }

    @Test
    void toRomanZero() {
        // arrange
        Integer number = 0;
        String expected = "";
        // act & assert
        assertRomanExpected(number, expected);
    }

    @Test
    void toRomanNegative() {
        // arrange
        Integer number = -1;
        String expected = "";
        // act & assert
        assertRomanExpected(number, expected);
    }

    private void assertRomanExpected(Integer number, String expected) {
        // act
        String actual = romanNumeralsRestController.toRoman(number);
        // assert
        assertEquals(expected, actual);
    }
}
