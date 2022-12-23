package com.bootcamp.edad.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {

    public static long calculateAge(LocalDate localDate) {
        return ChronoUnit.YEARS.between(localDate, LocalDate.now());
    }

}
