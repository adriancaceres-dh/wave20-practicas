package com.mercadolibre.romannumerals.controllerTest;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController romanController=  new RomanNumeralsRestController();

    @Test
    public void oneToI(){
        String expected= "I";
        String result=romanController.toRoman(1);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void threeToIII(){
        String expected= "III";
        String result=romanController.toRoman(3);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void fiveToV(){
        String expected= "V";
        String result=romanController.toRoman(5);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void sevenToVII(){
        String expected= "VII";
        String result=romanController.toRoman(7);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void tenToX(){
        String expected= "X";
        String result=romanController.toRoman(10);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void fiftyToL(){
        String expected= "L";
        String result=romanController.toRoman(50);
        Assertions.assertEquals(expected,result);
    }
}
