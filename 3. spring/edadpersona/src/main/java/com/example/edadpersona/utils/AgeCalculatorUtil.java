package com.example.edadpersona.utils;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorUtil {

    public static int getCurrentAge(int day, int month, int year) {
        LocalDate now = LocalDate.now();
        LocalDate birthdate = LocalDate.of(year, month, day);
        Period difference = Period.between(birthdate, now);

        return difference.getYears();
    }
}
