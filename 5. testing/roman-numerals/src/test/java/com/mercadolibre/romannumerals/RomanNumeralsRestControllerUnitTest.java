package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RomanNumeralsRestControllerUnitTest {
    @InjectMocks
    RomanNumeralsRestController romanNumeralsRestController;

    @Test
    void toRomanOk(){
        //Arrange
        String expected = "V";
        //Act
        String actual = romanNumeralsRestController.toRoman(5);
        //Assert
        assertEquals(expected, actual);
    }

}