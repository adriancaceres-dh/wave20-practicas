package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RomanNumeralsRestControllerTest {
    RomanNumeralsRestController romanNumeralsRestController=new RomanNumeralsRestController();

    @Test
    void oneShouldBeI() throws Exception {
        performTest(1, "I");
    }

    @Test
    void threeShouldBeIII() throws Exception {
        performTest(3, "III");
    }
    @Test
    void fiveShouldBeV() throws Exception {
        performTest(5, "V");
    }

    @Test
    void tenShouldBeX() throws Exception {
        performTest(10, "X");
    }

    @Test
    void sevenShouldBeVII() throws Exception {
        performTest(7, "VII");
    }

    @Test
    void fiftyShouldBeL() throws Exception {
        performTest(50, "L");
    }
    private void performTest(int decimal, String roman) throws Exception {
        //Act
        String response=romanNumeralsRestController.toRoman(decimal);
        //Assert
        Assertions.assertEquals(roman,response);
    }
}