package com.bootcamp.decimaltoroman.model;

import java.util.Arrays;
import java.util.Iterator;

public class DecimalToRomanConverter {

    private static final RomanNumber[] romanNumbers = {
            new RomanNumber("M", 1000),
            new RomanNumber("CM", 900),
            new RomanNumber("D", 500),
            new RomanNumber("CD", 400),
            new RomanNumber("C", 100),
            new RomanNumber("XC", 90),
            new RomanNumber("L", 50),
            new RomanNumber("XL", 40),
            new RomanNumber("X", 10),
            new RomanNumber("IX", 9),
            new RomanNumber("V", 5),
            new RomanNumber("IV", 4),
            new RomanNumber("I", 1),
    };

    public static String convert(int number) {
        validateNumber(number);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<RomanNumber> romanNumberIterator = Arrays.stream(romanNumbers).iterator();
        RomanNumber currentRomanNumber = romanNumberIterator.next();
        while (number != 0) {
            if (currentRomanNumber.numericalValue <= number) {
                stringBuilder.append(currentRomanNumber.representation);
                number -= currentRomanNumber.numericalValue;
            } else {
                currentRomanNumber = romanNumberIterator.next();
            }
        }
        return stringBuilder.toString();
    }

    private static void validateNumber(int number) {
        if (number > 3999) {
            throw new InvalidNumberForConversion("Number must be less than 4000");
        }
        if (number < 1) {
            throw new InvalidNumberForConversion("Number must be greater than 0");
        }
    }

    private static class RomanNumber {
        String representation;
        int numericalValue;

        public RomanNumber(String representation, int numericalValue) {
            this.representation = representation;
            this.numericalValue = numericalValue;
        }
    }

}
