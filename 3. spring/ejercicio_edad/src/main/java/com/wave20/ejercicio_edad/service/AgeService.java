package com.wave20.ejercicio_edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class AgeService {

    public static int getAge(int day, int month, int year) {
        int actualYear = LocalDate.now(ZoneId.systemDefault()).getYear();
        int actualMonth = LocalDate.now(ZoneId.systemDefault()).getMonthValue();
        int actualDay = LocalDate.now(ZoneId.systemDefault()).getDayOfMonth();
        int diff = actualYear - year;

        if (actualMonth > month) {
            return diff;
        } else if (actualMonth == month){
            if (actualDay < day) {
                return diff - 1;
            } else {
                return diff;
            }
        } else {
            return diff - 1;
        }

    }
}
